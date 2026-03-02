package com.uzum.mms.controller;

import com.uzum.mms.dto.request.TerminalRequest;
import com.uzum.mms.dto.response.TerminalResponse;
import com.uzum.mms.service.TerminalService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/terminals")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TerminalController {

    TerminalService terminalService;

    @GetMapping("/by-merchant-id/{id}")
    public Page<TerminalResponse> getByMerchantId(@PathVariable Long id, Pageable pageable) {
        return terminalService.getTerminalByMerchantId(id,pageable);
    }

    @PostMapping
    public ResponseEntity<TerminalResponse> registerPos(@Valid @RequestBody TerminalRequest request){
        TerminalResponse register = terminalService.register(request);
        return ResponseEntity.ok(register);
    }

    @GetMapping("/by-terminal-id/{id}")
    public TerminalResponse getByTerminalId(@PathVariable Long id) {
        return terminalService.getByTerminalId(id);
    }

}
