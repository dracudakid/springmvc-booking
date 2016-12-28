package com.mgmtp.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class RequestStatusPK implements Serializable {
    private int requestId;
    private int leaderId;
}
