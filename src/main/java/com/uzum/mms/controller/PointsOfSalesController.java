package com.uzum.mms.controller;

import com.uzum.mms.dto.request.TerminalRequest;
import com.uzum.mms.dto.response.TerminalResponse;
import com.uzum.mms.entity.MerchantEntity;
import com.uzum.mms.entity.TerminalEntity;
import com.uzum.mms.service.TerminalService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/mms/terminals/")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PointsOfSalesController {
    TerminalService service;

    @GetMapping("/by-merchant-id/{id}")
    public Page<TerminalEntity> getByMerchantId(@PathVariable Long id, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.getByMerchantId(id, page, size);
    }

    @PostMapping
    public ResponseEntity<TerminalResponse> registerPos(@Valid @RequestBody TerminalRequest request){
        TerminalEntity entityByRequest = service.getEntityByRequest(request);
        TerminalEntity savedEntity = service.register(entityByRequest);
        TerminalResponse response = service.getResponseByEntity(savedEntity);
        return ResponseEntity
                .ok(response);
    }
}
