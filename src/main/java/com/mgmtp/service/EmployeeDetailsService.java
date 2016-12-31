package com.mgmtp.service;

import com.mgmtp.model.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * This service is used for spring-security authentication using database
 */
public interface EmployeeDetailsService extends UserDetailsService{
    Employee getCurrentEmployee();
}
