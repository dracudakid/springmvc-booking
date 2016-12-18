package com.mgmtp.repository;

import com.mgmtp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tan Dat on 18/12/2016.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findById(int employeeId);
}
