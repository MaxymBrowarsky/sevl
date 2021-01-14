package ua.nulp.sevl.coding.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nulp.sevl.coding.form.CreateTaskForm;
import ua.nulp.sevl.coding.model.*;
import ua.nulp.sevl.coding.service.LabelService;
import ua.nulp.sevl.coding.service.SecurityService;
import ua.nulp.sevl.coding.service.TaskService;
import ua.nulp.sevl.coding.service.ThemeService;

import java.util.ArrayList;
import java.util.HashSet;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private ThemeService themeService;

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

}
