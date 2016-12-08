package com.mgmtp.controller;

import com.mgmtp.model.User;
import com.mgmtp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Tan Dat on 07/12/2016.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model){
        List<User> userList = userRepository.findAll();
        System.out.println(userList.toString());
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "registerForm";
        }
        userRepository.save(user);
        return "redirect:/users";
    }
}
