package com.uzum.mms.service.impl;

import com.uzum.mms.constant.enums.Status;
import com.uzum.mms.dto.request.MerchantRequest;
import com.uzum.mms.dto.request.UpdateMerchantRequest;
import com.uzum.mms.dto.response.MerchantResponse;
import com.uzum.mms.exception.DataNotFoundException;
import com.uzum.mms.mapper.MerchantMapper;
import com.uzum.mms.repository.MerchantRepository;
import com.uzum.mms.service.MerchantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    MerchantRepository merchantRepository;
    MerchantMapper merchantMapper;

    @Override
    public MerchantResponse create(MerchantRequest merchantRequest) {
        var merchant = merchantMapper.toEntity(merchantRequest);

        var saved = merchantRepository.save(merchant);

        log.info("Merchant saved successfully with id {}", saved.getId());

        return merchantMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        var merchant = merchantRepository
                .findById(id)
                .orElseThrow(() -> new DataNotFoundException("Merchant not found with id" + id));


        merchant.setMerchantStatus(Status.INACTIVE);

        log.info("Merchant deactivated successfully with id {}", merchant.getId());
    }

    @Override
    public MerchantResponse getById(Long id) {
        var merchant = merchantRepository
                .findById(id)
                .orElseThrow(() -> new DataNotFoundException("Merchant not found with id" + id));

        return merchantMapper.toResponse(merchant);
    }

    @Override
    @Transactional
    public void updateMerchantById(Long id, UpdateMerchantRequest request) {
        var merchant = merchantRepository
                .findById(id)
                .orElseThrow(() -> new DataNotFoundException("Merchant not found with id" + id));

        merchantMapper.updateMerchantFromDto(request,merchant);

        log.info("Merchant updated successfully with id {}", merchant.getId());
    }
}
