package com.uzum.mms.repository;

import com.uzum.mms.entity.TerminalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TerminalRepository extends JpaRepository<TerminalEntity,Long> {
    Page<TerminalEntity> getTerminalEntitiesByMerchantId(Long id, Pageable pageable);
}
