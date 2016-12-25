package com.mgmtp.service;

import com.mgmtp.model.Employee;
import com.mgmtp.model.Request;
import com.mgmtp.repository.EmployeeRepository;
import com.mgmtp.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

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
    public void save(Request request) {
        int employeeId = 3;
        Employee employee = employeeRepository.findOne(3);
        request.setEmployee(employee);
        request.setCreatedAt(new Date());
        requestRepository.save(request);
    }
}
