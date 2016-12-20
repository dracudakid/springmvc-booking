package com.mgmtp.controller;

import com.mgmtp.model.Request;
import com.mgmtp.service.EmployeeService;
import com.mgmtp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/my-request")
public class MyRequestController {
    @Autowired
    RequestService requestService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history(@RequestParam(value = "page", required = false) Integer pageNumber,
                          @RequestParam(value = "limit", required = false) Integer limit,
                          Model model){

//        List<Request> requests = requestService.findMyRequestHistory();
        if(pageNumber == null) pageNumber = 1;
        if(limit == null) limit = 1;
        Page<Request> requests = requestService.findALl(pageNumber, limit);
        int currentIndex = requests.getNumber() + 1;
        int beginIndex = Math.max(1, currentIndex - 3);
        int endIndex = Math.min(beginIndex + 6, requests.getTotalPages());

        model.addAttribute("requests", requests);
        model.addAttribute("beginIndex", beginIndex);
        model.addAttribute("endIndex", endIndex);
        model.addAttribute("currentIndex", currentIndex);

        return "myrequest/history";
    }
}
