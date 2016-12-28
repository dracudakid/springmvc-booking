package com.mgmtp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"requests", "leader", "employees", "requestStatuses", "roles"})
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
    private Set<Employee> employees;
    @OneToMany(mappedBy = "leader")
    private Set<RequestStatus> requestStatuses;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @Transient
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
