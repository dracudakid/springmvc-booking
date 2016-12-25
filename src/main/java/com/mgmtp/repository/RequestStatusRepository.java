package com.mgmtp.repository;

import com.mgmtp.model.RequestStatus;
import com.mgmtp.model.RequestStatusPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestStatusRepository extends JpaRepository<RequestStatus, RequestStatusPK> {
    List<RequestStatus> findByIdLeaderId(int leaderId);
    List<RequestStatus> findByIdRequestId(int requestId);
}
