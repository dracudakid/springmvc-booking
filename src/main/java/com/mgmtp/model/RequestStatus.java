package com.mgmtp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"request", "leader"})
@Entity
@Table(name = "request_status")
public class RequestStatus {
    @EmbeddedId
    private RequestStatusPK id;

    @MapsId("requestId")
    @ManyToOne
    @JoinColumn(name = "request_id", insertable = false, updatable = false)
    private Request request;

    @MapsId("leaderId")
    @ManyToOne
    @JoinColumn(name = "leader_id", insertable = false, updatable = false)
    private Employee leader;

    @Basic
    @Column(name = "approved")
    private Boolean approved;

    public RequestStatus(Request request, Employee leader){
        this.id = new RequestStatusPK(request.getId(), leader.getId());
        this.request = request;
        this.leader = leader;
    }
}
