package com.uzum.mms.service;

import com.uzum.mms.dto.request.MerchantRequest;
import com.uzum.mms.dto.request.UpdateMerchantRequest;
import com.uzum.mms.dto.response.MerchantResponse;
import org.springframework.data.domain.Page;

public interface MerchantService {
    MerchantResponse create(MerchantRequest merchantRequest);
    void deleteById(Long id);
    MerchantResponse getById(Long id);
    void updateMerchantById(Long id, UpdateMerchantRequest request);
}
