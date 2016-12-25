package com.mgmtp.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "start_working_date")
    private Date startWorkingDate;
    @OneToMany(mappedBy = "employee")
    private List<Request> requests;
    @ManyToOne
    @JoinColumn(name = "leader_id")
    private Employee leader;

    @OneToMany(mappedBy = "leader")
    private List<Employee> employees;
    @OneToMany(mappedBy = "id.leader")
    private List<RequestStatus> requestStatuses;

    @Transient
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
