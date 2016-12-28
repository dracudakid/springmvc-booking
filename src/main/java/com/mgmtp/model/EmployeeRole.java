package com.mgmtp.model;

import lombok.Data;

import javax.persistence.*;

@Deprecated
@Data
@Entity
@Table(name = "employee_role")
public class EmployeeRole {
    @EmbeddedId
    EmployeeRolePK id;

    @MapsId("employeeId")
    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

    @MapsId("roleId")
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
}
