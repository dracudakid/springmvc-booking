package com.mgmtp.model;

import javax.persistence.*;

/**
 * Created by Tan Dat on 18/12/2016.
 */
@Entity
@Table(name = "request_status")
public class RequestStatus {
    private RequestStatusPK id;
    private Boolean approved;

    @EmbeddedId
    public RequestStatusPK getId() {
        return id;
    }

    public void setId(RequestStatusPK id) {
        this.id = id;
    }



    @Basic
    @Column(name = "approved")
    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestStatus that = (RequestStatus) o;
//
//        if (requestId != that.requestId) return false;
//        if (leaderId != that.leaderId) return false;
        if (approved != null ? !approved.equals(that.approved) : that.approved != null) return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        int result = requestId;
//        result = 31 * result + leaderId;
//        result = 31 * result + (approved != null ? approved.hashCode() : 0);
//        return result;
//    }
}
