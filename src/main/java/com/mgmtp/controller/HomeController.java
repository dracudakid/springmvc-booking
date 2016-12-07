package com.mgmtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Tan Dat on 06/12/2016.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "index";
    }
}
