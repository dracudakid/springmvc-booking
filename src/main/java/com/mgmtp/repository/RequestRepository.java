package com.mgmtp.repository;

import com.mgmtp.model.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository  extends JpaRepository<Request, Integer> {
    @Override
    List<Request> findAll();
    List<Request> findByEmployeeId(int employeeId);

    @Override
    Page<Request> findAll(Pageable pageable);
}
