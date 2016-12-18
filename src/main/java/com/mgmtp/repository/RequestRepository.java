package com.mgmtp.repository;

import com.mgmtp.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Tan Dat on 16/12/2016.
 */
public interface RequestRepository  extends JpaRepository<Request, Long> {
    @Override
    List<Request> findAll();
    List<Request> findByEmployeeId(int employeeId);
}
