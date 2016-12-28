package com.mgmtp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "yearly_quota")
public class YearlyQuota {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "year")
    private int year;

    @Basic
    @Column(name = "quota")
    private int quota;

    @ManyToOne
    @JoinColumn(name = "vacation_type_id")
    private VacationType vacationType;

}
