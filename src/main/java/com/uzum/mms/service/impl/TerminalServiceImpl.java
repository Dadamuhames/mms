package com.uzum.mms.service.impl;

import com.uzum.mms.dto.request.TerminalRequest;
import com.uzum.mms.dto.response.TerminalResponse;
import com.uzum.mms.entity.MerchantEntity;
import com.uzum.mms.entity.TerminalEntity;
import com.uzum.mms.exception.DataNotFoundException;
import com.uzum.mms.mapper.TerminalMapper;
import com.uzum.mms.repository.MerchantRepository;
import com.uzum.mms.repository.TerminalRepository;
import com.uzum.mms.service.TerminalService;
import com.uzum.mms.utils.PointsOfSalesPaginator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TerminalServiceImpl implements TerminalService {
    TerminalMapper mapper;
    TerminalRepository terminalRepository;
    MerchantRepository merchantRepository;
    private final TerminalMapper terminalMapper;

    @Override
    @Transactional
    public TerminalResponse register(TerminalRequest terminalRequest) {
        var merchant = merchantRepository
                .findById(terminalRequest.merchantId())
                .orElseThrow(() -> new DataNotFoundException("Merchant not found"));

        var terminal = mapper.toEntity(terminalRequest);

        terminal.setMerchant(merchant);

        var saved=terminalRepository.save(terminal);

        return mapper.toResponse(saved);

    }


    @Override
    public Page<TerminalResponse> getTerminalByMerchantId(Long id, Pageable pageable) {
        Page<TerminalEntity> terminals = terminalRepository.getTerminalEntitiesByMerchant_Id(id, pageable);
        return terminals.map(mapper::toResponse);
    }

    @Override
    public TerminalResponse getByTerminalId(Long id) {
        var terminalEntity = terminalRepository
                .findById(id)
                .orElseThrow(() -> new DataNotFoundException("Terminal not found with id" + id));

        return terminalMapper.toResponse(terminalEntity);
    }

}
