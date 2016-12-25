package com.mgmtp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "request_status")
public class RequestStatus {
    @EmbeddedId
    private RequestStatusPK id;

    @Basic
    @Column(name = "approved")
    private Boolean approved;

}
