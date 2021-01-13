package ua.nulp.sevl.coding.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.nulp.sevl.coding.model.User;
import ua.nulp.sevl.coding.service.SecurityService;
import ua.nulp.sevl.coding.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private ResponseEntity<User> createUser(@RequestParam String u) {
        System.out.println(u);
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
        User user=new User();
        try {
            user = mapper.readValue(u, User.class);
        }
        catch (Exception err)
        {
            err.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        userService.createUser(user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getRoles(), user.getAttempts());
        System.out.println(user.getName());
        return  new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String password) {
        securityService.autoLogin(login, password);
        if (securityService.findLoggedInUsername() == login) {
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);


    }
    @RequestMapping(value = {"/", "/welcome/{id}"}, method = RequestMethod.GET, params = {"test"})
    public ResponseEntity<String> welcome(@RequestParam(value="test") String test) {
        System.out.println(test);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
