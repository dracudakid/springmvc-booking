package com.mgmtp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"request", "leader"})
@Entity
@Table(name = "request_status")
public class RequestStatus {
    @EmbeddedId
    private RequestStatusPK id;

    @MapsId("requestId")
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @MapsId("leaderId")
    @ManyToOne
    @JoinColumn(name = "leader_id")
    private Employee leader;

    @Basic
    @Column(name = "approved")
    private Boolean approved;
}
