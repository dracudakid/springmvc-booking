package com.mgmtp.controller;


import com.mgmtp.model.Employee;
import com.mgmtp.model.RequestStatus;
import com.mgmtp.repository.EmployeeRepository;
import com.mgmtp.repository.RequestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EmployeeRepository employeeRepository;

    private final RequestStatusRepository requestStatusRepository;

    @Autowired
    public AdminController(EmployeeRepository employeeRepository, RequestStatusRepository requestStatusRepository) {
        this.employeeRepository = employeeRepository;
        this.requestStatusRepository = requestStatusRepository;
    }

    @RequestMapping(value = "/pending_requests", method = RequestMethod.GET)
    public String history(@RequestParam(value = "page", defaultValue = "1", required = false) Integer pageNumber,
                          @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
                          Model model){
        if (pageNumber < 1) return "redirect:/admin/pending_requests";

        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        Employee currentEmployee = employeeRepository.findByEmail(email);
        // TODO: implement pagination here
        Page<RequestStatus> requestStatusPage = requestStatusRepository.findByLeaderId(currentEmployee.getId(),new PageRequest(pageNumber-1, Integer.MAX_VALUE));

        if(pageNumber > requestStatusPage.getTotalPages()) return "redirect:/leader/listPendingRequest";
        model.addAttribute("requestStatuses", requestStatusPage.getContent());
        model.addAttribute("currentUser", currentEmployee);
        MyRequestController.setPaginationInfo(model, requestStatusPage);

        return "admin/pending_requests";
    }

}
