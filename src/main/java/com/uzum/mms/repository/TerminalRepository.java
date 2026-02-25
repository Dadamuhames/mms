package com.uzum.mms.repository;

import com.uzum.mms.entity.TerminalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TerminalRepository extends JpaRepository<TerminalEntity,Long> {

    Page<TerminalEntity> getTerminalEntitiesByMerchant_Id(Long merchantId, Pageable pageable);
}
