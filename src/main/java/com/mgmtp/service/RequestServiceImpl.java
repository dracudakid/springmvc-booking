package com.mgmtp.service;

import com.mgmtp.model.Employee;
import com.mgmtp.model.Request;
import com.mgmtp.model.RequestStatus;
import com.mgmtp.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final EmployeeDetailsService employeeDetailsService;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository, EmployeeDetailsService employeeDetailsService) {
        this.requestRepository = requestRepository;
        this.employeeDetailsService = employeeDetailsService;
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> findMyRequestHistory() {
        int employeeId = 3; // hard code
        return requestRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Page<Request> findALl(Integer pageNumber, Integer limit) {
        PageRequest request =
                new PageRequest(pageNumber - 1, limit);
        return requestRepository.findAll(request);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Request request) {
        Employee employee = employeeDetailsService.getCurrentEmployee();
        request.setEmployee(employee);
        request.setCreatedAt(new Date());
        requestRepository.save(request);
        Set<RequestStatus> requestStatuses = new HashSet<>();
        for (Employee approver: employee.getApprovers()) {
            RequestStatus requestStatus = new RequestStatus(request, approver);
            requestStatuses.add(requestStatus);
        }
        request.setRequestStatuses(requestStatuses);
        requestRepository.save(request);
    }
}
