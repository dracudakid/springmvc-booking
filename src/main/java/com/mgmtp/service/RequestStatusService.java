package com.mgmtp.service;

import com.mgmtp.model.RequestStatus;

public interface RequestStatusService {
    RequestStatus updateRequestStatus(int requestId, String action);
}
