package com.mgmtp.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Tan Dat on 18/12/2016.
 */
@Entity
public class Request {
    private int id;
    private Date fromDate;
    private Date toDate;
    private Timestamp createdAt;
    private String comment;
    private VacationType vacationType;
    private Employee employee;
    private List<RequestStatus> requestStatuses;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "from_date")
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "to_date")
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Transient
    public String getStatus(){
        return
                this.requestStatuses.stream().anyMatch(rs -> rs.getApproved() == null)
                        ? "Pending"
                        : this.requestStatuses.stream().allMatch(rs -> rs.getApproved())
                            ? "Approved" : "Rejected";
    };
    @Transient
    public int getDays(){
        int diffInDays = (int)( (toDate.getTime() - fromDate.getTime())
                / (1000 * 60 * 60 * 24) );
        return diffInDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (id != request.id) return false;
        if (fromDate != null ? !fromDate.equals(request.fromDate) : request.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(request.toDate) : request.toDate != null) return false;
        if (createdAt != null ? !createdAt.equals(request.createdAt) : request.createdAt != null) return false;
        if (comment != null ? !comment.equals(request.comment) : request.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "vacation_type_id")
    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(mappedBy = "id.request", fetch = FetchType.EAGER)
    public List<RequestStatus> getRequestStatuses() {
        return requestStatuses;
    }

    public void setRequestStatuses(List<RequestStatus> requestStatuses) {
        this.requestStatuses = requestStatuses;
    }
}
