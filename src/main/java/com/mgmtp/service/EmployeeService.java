package com.mgmtp.service;

import com.mgmtp.model.Employee;

import java.util.List;

/**
 * Created by Tan Dat on 18/12/2016.
 */
public interface EmployeeService {
    List<Employee> findMyLeaders();
}
