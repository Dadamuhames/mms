package com.uzum.mms.service.impl;

import com.uzum.mms.dto.request.TerminalRequest;
import com.uzum.mms.dto.response.TerminalResponse;
import com.uzum.mms.entity.TerminalEntity;
import com.uzum.mms.mapper.TerminalMapper;
import com.uzum.mms.repository.TerminalRepository;
import com.uzum.mms.service.TerminalService;
import com.uzum.mms.utils.PointsOfSalesPaginator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TerminalServiceImpl implements TerminalService {
    TerminalMapper mapper;
    TerminalRepository terminalRepository;

    @Override
    @Transactional
    public TerminalEntity register(TerminalEntity entity) {
        return terminalRepository.save(entity);
    }

    @Override
    public TerminalEntity getEntityByRequest(TerminalRequest request){
        return mapper.toEntity(request);
    }

    @Override
    public TerminalResponse getResponseByEntity(TerminalEntity entity){
        return mapper.toResponse(entity);
    }

    @Override
    public Page<TerminalEntity> getByMerchantId(Long id, int page, int size) {
        return terminalRepository
                .getTerminalEntitiesByMerchantId(
                        id,
                        PointsOfSalesPaginator.validate(page, size));
    }
}
