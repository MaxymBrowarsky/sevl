package ua.nulp.sevl.coding.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nulp.sevl.coding.model.Task;
import ua.nulp.sevl.coding.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private ResponseEntity<Task> createTask(@RequestParam String t) {
        System.out.println(t);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
        Task task = new Task();
        try {
            task = mapper.readValue(t, Task.class);
        }
        catch (Exception err)
        {
            err.printStackTrace();
            return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
        }
        taskService.createTask(task.getTitle(), task.getDescription(), task.getAuthor(),
                task.getTheme(), task.getTestCases(), task.getLabels(), task.getAttempts());
        System.out.println(task.getTitle());
        return  new ResponseEntity<Task>(task,HttpStatus.OK);
    }
}
