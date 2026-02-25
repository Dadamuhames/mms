package com.uzum.mms.service;

import com.uzum.mms.dto.request.TerminalRequest;
import com.uzum.mms.dto.response.TerminalResponse;
import com.uzum.mms.entity.TerminalEntity;
import org.springframework.data.domain.Page;

public interface TerminalService {
    TerminalEntity register(TerminalEntity entity);
    TerminalEntity getEntityByRequest(TerminalRequest request);
    TerminalResponse getResponseByEntity(TerminalEntity entity);
    Page<TerminalEntity> getByMerchantId(Long id, int page, int size);
}
