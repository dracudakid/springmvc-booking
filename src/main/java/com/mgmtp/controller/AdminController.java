package com.mgmtp.controller;


import com.mgmtp.model.Employee;
import com.mgmtp.model.Request;
import com.mgmtp.model.RequestStatus;
import com.mgmtp.model.RequestStatusPK;
import com.mgmtp.repository.EmployeeRepository;
import com.mgmtp.repository.RequestStatusRepository;
import com.mgmtp.repository.VacationTypeRepository;
import com.mgmtp.service.EmployeeService;
import com.mgmtp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final int MAX_PAGES_IN_PAGINATION = 9;

    @Autowired
    private RequestService requestService;

    @Autowired
    private VacationTypeRepository vacationTypeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RequestStatusRepository requestStatusRepository;

    @RequestMapping(value = "/pending_requests", method = RequestMethod.GET)
    public String history(@RequestParam(value = "page", defaultValue = "1", required = false) Integer pageNumber,
                          @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
                          Model model){
        if (pageNumber < 1) return "redirect:/admin/pending_requests";

        Employee emp = employeeRepository.findOne(1);

        Page<RequestStatus> adminPendingRequestPage = requestStatusRepository.findByLeaderIdPage(1,new PageRequest(pageNumber-1,limit));

        if(pageNumber > adminPendingRequestPage.getTotalPages()) return "redirect:/leader/listPendingRequest";
        model.addAttribute("listAdminPendingRequest", adminPendingRequestPage.getContent());
        model.addAttribute("currentUser", emp);
        MyRequestController.setPaginationInfo(model, adminPendingRequestPage);

        return "admin/pending_requests";
    }

}
