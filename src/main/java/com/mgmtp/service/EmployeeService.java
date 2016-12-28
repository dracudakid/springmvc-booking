package com.mgmtp.service;

import com.mgmtp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findMyLeaders();
    Employee findByEmail(String email);
}
