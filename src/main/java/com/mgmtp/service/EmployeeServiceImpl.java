package com.mgmtp.service;

import com.mgmtp.model.Employee;
import com.mgmtp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findMyLeaders() {
        int employeeId = 3;
        List<Employee> leaders = new ArrayList<>();
        Employee employee = employeeRepository.findById(employeeId);
        Employee leader = employee.getLeader();
        while(leader != null){
            leaders.add(leader);
            leader = leader.getLeader();
        }
        return leaders;
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
