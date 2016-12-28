package com.mgmtp.repository;

import com.mgmtp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findById(int employeeId);
    Employee findByEmail(String email);
}
