package com.mgmtp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"requests", "leader", "employees", "requestStatuses", "roles", "approvers"})
@ToString(exclude = {"requests", "leader", "employees", "requestStatuses", "roles", "approvers"})
@Entity
public class Employee {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @Temporal(TemporalType.DATE)
    @Basic
    @DateTimeFormat(pattern = "MMM d, yyyy")
    @Column(name = "start_working_date")
    private Date startWorkingDate;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Request> requests;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    private Employee leader;

    @OneToMany(mappedBy = "leader")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "leader", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<RequestStatus> requestStatuses;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_approver",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "approver_id", referencedColumnName = "id"))
    private Set<Employee> approvers;

    @Transient
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
