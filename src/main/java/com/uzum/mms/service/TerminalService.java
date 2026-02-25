package com.uzum.mms.service;

import com.uzum.mms.dto.request.TerminalRequest;
import com.uzum.mms.dto.response.TerminalResponse;
import com.uzum.mms.entity.TerminalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TerminalService {
    TerminalResponse register(TerminalRequest terminalRequest);
    Page<TerminalResponse> getTerminalByMerchantId(Long id, Pageable pageable);
}
