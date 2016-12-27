package com.mgmtp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class EmployeeRolePK implements Serializable {
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "employee_id")
    private int employeeId;
}
