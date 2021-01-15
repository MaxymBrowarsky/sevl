package ua.nulp.sevl.coding.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.nulp.sevl.coding.form.UserForm;
import ua.nulp.sevl.coding.model.User;
import ua.nulp.sevl.coding.service.SecurityService;
import ua.nulp.sevl.coding.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getRoles(), user.getAttempts());
        System.out.println(user.getName());
        return  new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @GetMapping(value = "/user/login")
    public String login(Model model) {
        UserForm uf = new UserForm();
        model.addAttribute("user", uf);
        return "login";
    }
    @GetMapping(value = "/index")
    public String index(Model model) {
        System.out.println("indexsssss");
        return "index";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        System.out.println(login);
        System.out.println(password);
        securityService.autoLogin(login, password);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.println(currentUserName);
        }

        if (securityService.findLoggedInUsername().equals(login)) {
            return  "redirect:/task/all";
        }
        return  "user/login";


    }
    @RequestMapping(value = {"/", "/welcome/{id}"}, method = RequestMethod.GET, params = {"test"})
    public ResponseEntity<String> welcome(@RequestParam(value="test", required = false) String test) {
        System.out.println(test);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
