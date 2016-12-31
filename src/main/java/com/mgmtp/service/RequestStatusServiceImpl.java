package com.mgmtp.service;

import com.mgmtp.model.Employee;
import com.mgmtp.model.RequestStatus;
import com.mgmtp.model.RequestStatusPK;
import com.mgmtp.repository.RequestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestStatusServiceImpl implements RequestStatusService {
    private final EmployeeDetailsService employeeDetailsService;
    private final RequestStatusRepository requestStatusRepository;

    @Autowired
    public RequestStatusServiceImpl(EmployeeDetailsService employeeDetailsService, RequestStatusRepository requestStatusRepository) {
        this.employeeDetailsService = employeeDetailsService;
        this.requestStatusRepository = requestStatusRepository;
    }

    @Override
    public RequestStatus updateRequestStatus(int requestId, String action) {
        Employee employee = employeeDetailsService.getCurrentEmployee();
        RequestStatus requestStatus = requestStatusRepository.findOne(new RequestStatusPK(requestId, employee.getId()));
        switch (action){
            case "Accept":
                requestStatus.setApproved(true);
                break;
            case "Reject":
                requestStatus.setApproved(false);
                break;
            case "Pending":
                requestStatus.setApproved(null);
        }
        return requestStatusRepository.save(requestStatus);
    }
}
