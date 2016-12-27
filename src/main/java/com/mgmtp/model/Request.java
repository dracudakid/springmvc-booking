package com.mgmtp.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Request {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Basic
    @Column(name = "from_date")
    @DateTimeFormat(pattern = "MMM d, yyyy")
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    @Basic
    @Column(name = "to_date")
    @DateTimeFormat(pattern = "MMM d, yyyy")
    private Date toDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    @Column(name = "created_at")
    private Date createdAt;

    @Basic
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "vacation_type_id")
    private VacationType vacationType;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "id.request", fetch = FetchType.EAGER)
    private List<RequestStatus> requestStatuses;


    @Transient
    public String getStatus(){
        return
                this.requestStatuses.stream().anyMatch(rs -> rs.getApproved() == null)
                        ? "Pending"
                        : this.requestStatuses.stream().allMatch(RequestStatus::getApproved)
                            ? "Approved" : "Rejected";
    }

    @Transient
    public int getDays(){
        return (int)( (toDate.getTime() - fromDate.getTime())
                / (1000 * 60 * 60 * 24) );
    }
}
