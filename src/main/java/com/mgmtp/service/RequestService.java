package com.mgmtp.service;

import com.mgmtp.model.Request;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Tan Dat on 16/12/2016.
 */
public interface RequestService {
    List<Request> findAll();
    Page<Request> findALl(Integer pageNumber, Integer limit);
    List<Request> findMyRequestHistory();

}
