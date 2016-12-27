package com.mgmtp.repository;

import com.mgmtp.model.RequestStatus;
import com.mgmtp.model.RequestStatusPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestStatusRepository extends JpaRepository<RequestStatus, RequestStatusPK> {
    List<RequestStatus> findByIdLeaderId(int leaderId);
    List<RequestStatus> findByIdRequestId(int requestId);

    @Query("SELECT a FROM  RequestStatus a WHERE a.id.leader.id = :leaderID")
    Page<RequestStatus> findByLeaderIdPage(@Param("leaderID") int leaderID, Pageable pageable);
}
