package com.mgmtp.service;

import com.mgmtp.model.Employee;
import com.mgmtp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tan Dat on 18/12/2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
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
}
