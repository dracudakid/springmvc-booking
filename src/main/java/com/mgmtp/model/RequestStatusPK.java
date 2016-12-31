package com.mgmtp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RequestStatusPK implements Serializable {
    @Column(name = "request_id")
    private int requestId;
    @Column(name = "leader_id")
    private int leaderId;
}
