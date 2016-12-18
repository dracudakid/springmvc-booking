package com.mgmtp.controller;

import com.mgmtp.model.Request;
import com.mgmtp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/my-request")
public class MyRequestController {
    @Autowired
    RequestService requestService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history(Model model){
        List<Request> requests = requestService.findMyRequestHistory();
        model.addAttribute("requests", requests);
        return "myrequest/history";
    }
}
