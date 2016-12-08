package com.mgmtp.controller;

import com.mgmtp.model.User;
import com.mgmtp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
