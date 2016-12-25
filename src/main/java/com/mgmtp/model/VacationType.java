package com.mgmtp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "vacation_type")
public class VacationType {
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "depend_on_start_working_date")
    private boolean dependOnStartWorkingDate;

    @OneToMany(mappedBy = "vacationType")
    private List<Request> requests;
}
