package com.mgmtp.service;

import com.mgmtp.model.Request;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RequestService {
    List<Request> findAll();
    Page<Request> findALl(Integer pageNumber, Integer limit);
    List<Request> findMyRequestHistory();
    void save(Request request);

}
