package com.uzum.mms.repository;

import com.uzum.mms.entity.TerminalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TerminalRepository extends JpaRepository<TerminalEntity,Long> {
//    @Query("""
//        SELECT t
//        FROM terminal_entity t
//        WHERE t.merchant.id = :id
//    """)
    Page<TerminalEntity> getTerminalEntitiesByMerchantId(@Param("id") Long id, Pageable pageable);
}
