package ua.nulp.sevl.coding.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.nulp.sevl.coding.form.CreateTaskForm;
import ua.nulp.sevl.coding.form.TaskResult;
import ua.nulp.sevl.coding.model.*;
import ua.nulp.sevl.coding.service.*;
import ua.nulp.sevl.coding.util.BadCodeException;
import ua.nulp.sevl.coding.util.CodeExecutor;
import ua.nulp.sevl.coding.util.CompileException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/task")
@SessionAttributes({"currentSolution", "results", "grade"})
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private UserService userService;
    @Autowired
    private AttemptService attemptService;

//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    private ResponseEntity<Task> createTask(@RequestParam String t) {
//        System.out.println(t);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
//        Task task = new Task();
//        try {
//            task = mapper.readValue(t, Task.class);
//        }
//        catch (Exception err)
//        {
//            err.printStackTrace();
//            return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
//        }
//        taskService.createTask(task.getTitle(), task.getDescription(), task.getAuthor(),
//                task.getTheme(), task.getTestCases(), task.getLabels(), task.getAttempts());
//        System.out.println(task.getTitle());
//        return  new ResponseEntity<Task>(task,HttpStatus.OK);
//    }

    @GetMapping(value = "/create")
    public String index(Model model) {
        CreateTaskForm createTaskForm = new CreateTaskForm();
        model.addAttribute("task", createTaskForm);
        System.out.println("=== create form ===");
        return "createTask";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> createTask(@RequestParam String title, @RequestParam String labels, @RequestParam String theme, @RequestParam String description) {


        //add all labels
        ArrayList<Label> labelsSet= new ArrayList<>();
        for (String lb: labels.split(" ")
             ) {
            if(labelService.findByText(lb) != null) {
                labelsSet.add(labelService.findByText(lb));
            } else {
                Label label = new Label(lb);
                labelService.save(label);//TODO maybe not there
                labelsSet.add(label);
            }
        }

        //add theme
        Theme themeObj = themeService.findByText(theme);
        if(themeObj == null) {
            themeObj = new Theme(theme);
            themeService.save(themeObj);//TODO maybe not there
        }

        String authorName = "name";//TODO get from logined user
        Task task = new Task(title, description, authorName, themeObj,
                new ArrayList<>(),//TODO add test cases
                labelsSet,
                new ArrayList<>());
        taskService.save(task);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public String all(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userService.findByLogin(currentUserName);
            model.addAttribute("login", user.getLogin());
        }
        System.out.println("=== tasksList ===");
        return "tasksList";
    }

    @GetMapping(value = "/{id}")
    public String task(Model model, @PathVariable String id) {
        //@ModelAttribute("currentSolution") String solution,
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userService.findByLogin(currentUserName);
            model.addAttribute("login", user.getLogin());
        }
        if(model.containsAttribute("results")){
            model.addAttribute("results", model.getAttribute("results"));
        }else {
           // model.addAttribute("results", )
        }

        if(model.containsAttribute("grade")){
            model.addAttribute("grade", model.getAttribute("grade"));
        }else {
            model.addAttribute("grade", "0");
        }

        String defSol = "початкове значення";
        if(model.containsAttribute("currentSolution")){
            model.addAttribute("currentSolution", model.getAttribute("currentSolution").toString());
        } else {
            model.addAttribute("currentSolution", defSol);
        }
        Task task = taskService.find(Long.parseLong(id));
        model.addAttribute("task", task);
        model.addAttribute("attempt", new Attempt());
        model.addAttribute("id", id);

        System.out.println("=== task "+ id +" ===");
        return "task";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String attempt(Model model, @RequestParam String id, @RequestParam String solution) {
        Attempt attempt = new Attempt();

        Task task = taskService.find(Long.parseLong(id));
        List<TestCase> testCases = task.getTestCases();

        List<TaskResult> taskResults = new ArrayList<>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userService.findByLogin(currentUserName);

            CodeExecutor codeExecutor = new CodeExecutor();
            codeExecutor.SaveToFile(solution);
            ArrayList<Boolean> successTestCase = new ArrayList<>();
            try {
                codeExecutor.compile();
                for (TestCase tc: testCases
                     ) {
                    try{
                        CodeExecutor.TestResult tr = codeExecutor.executeCode(tc);
                        System.out.println("==============================================");
                        System.out.println(tr.isSuccess());
                        System.out.println(tr.getResult());
                        successTestCase.add(tr.isSuccess());
                        taskResults.add(new TaskResult(tr.isSuccess(), tc.getResult(), tr.getResult()));
                    } catch (BadCodeException e){
                        //TODO
                    }
                }
            } catch (CompileException e) {
                e.printStackTrace();//TODO
            }

            attempt.setUser(user);
            int grade = (int)( (successTestCase.stream().filter(x -> x.booleanValue()).count())/
                    ((double) testCases.size()) * 100);
            attempt.setGrade(grade);//TODO
            model.addAttribute("grade", grade);
            attempt.setSolution(solution);
            attempt.setTime(0L);
            attemptService.save(attempt);
        }

        model.addAttribute("results", taskResults);
        model.addAttribute("currentSolution", solution);

        return "redirect:/task/"+id;
    }

}
