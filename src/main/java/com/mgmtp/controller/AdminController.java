package com.mgmtp.controller;


import com.mgmtp.model.Employee;
import com.mgmtp.model.RequestStatus;
import com.mgmtp.repository.RequestStatusRepository;
import com.mgmtp.service.EmployeeDetailsService;
import com.mgmtp.service.RequestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RequestStatusRepository requestStatusRepository;
    private final EmployeeDetailsService employeeDetailsService;
    private final RequestStatusService requestStatusService;

    @Autowired
    public AdminController(RequestStatusRepository requestStatusRepository,
                           EmployeeDetailsService employeeDetailsService,
                           RequestStatusService requestStatusService) {
        this.requestStatusRepository = requestStatusRepository;
        this.employeeDetailsService = employeeDetailsService;
        this.requestStatusService = requestStatusService;
    }

    @RequestMapping(value = "/pending_requests", method = RequestMethod.GET)
    public String history(@RequestParam(value = "page", defaultValue = "1", required = false) Integer pageNumber,
                          @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
                          Model model){
        if (pageNumber < 1) return "redirect:/admin/pending_requests";

        Employee currentEmployee = employeeDetailsService.getCurrentEmployee();
        // TODO: implement pagination here
        Page<RequestStatus> requestStatusPage = requestStatusRepository.findByLeaderId(currentEmployee.getId(),new PageRequest(pageNumber-1, Integer.MAX_VALUE));

        if(pageNumber > requestStatusPage.getTotalPages()) return "redirect:/leader/listPendingRequest";
        model.addAttribute("requestStatuses", requestStatusPage.getContent());
        model.addAttribute("currentUser", currentEmployee);
        MyRequestController.setPaginationInfo(model, requestStatusPage);

        return "admin/pending_requests";
    }

    @ResponseBody
    @RequestMapping(value = "/pending_requests/{id}", method = RequestMethod.POST)
    public String processPendingRequest(@PathVariable(value = "id") int requestId, @RequestParam(value = "action", required = true) String action){
        return requestStatusService.updateRequestStatus(requestId, action).toString();
    }
}
