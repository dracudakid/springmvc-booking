package com.mgmtp.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RequestStatusPK implements Serializable {
    private Request request;
    private Employee leader;

    @ManyToOne
    @JoinColumn(name = "request_id")
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @ManyToOne
    @JoinColumn(name = "leader_id")
    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        RequestStatusPK that = (RequestStatusPK) o;
//
//        if (request != that.requestId) return false;
//        if (leaderId != that.leaderId) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = requestId;
//        result = 31 * result + leaderId;
//        return result;
//    }
}
