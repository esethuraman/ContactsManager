package contacts.controller;

import contacts.domain.User;
import contacts.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String onLogin(){
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String onRegister(User user){
        userRepository.save(user);
        return "redirect:/";
    }


}
