package com.mgmtp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"employees"})
@Entity
public class Role {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<Employee> employees;
}
