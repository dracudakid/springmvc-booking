package com.mgmtp.service;

import com.mgmtp.model.Request;
import com.mgmtp.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tan Dat on 16/12/2016.
 */
@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestRepository requestRepository;

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> findMyRequestHistory() {
        int employeeId = 3; // hard code
        return requestRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Page<Request> findALl(Integer pageNumber, Integer limit) {
        PageRequest request =
                new PageRequest(pageNumber - 1, limit);
        return requestRepository.findAll(request);
    }
}
