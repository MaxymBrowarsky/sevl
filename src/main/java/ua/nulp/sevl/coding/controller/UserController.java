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
import ua.nulp.sevl.coding.model.User;
import ua.nulp.sevl.coding.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

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
        userService.createUser(user.getName(), user.getSurname(), user.getLogin(), user.getPassword());
        System.out.println(user.getName());
        return  new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
