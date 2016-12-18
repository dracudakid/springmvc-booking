package com.mgmtp.service;

import com.mgmtp.model.Request;

import java.util.List;

/**
 * Created by Tan Dat on 16/12/2016.
 */
public interface RequestService {
    List<Request> findAll();
    List<Request> findMyRequestHistory();
}
