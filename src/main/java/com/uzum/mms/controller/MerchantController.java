package com.uzum.mms.controller;

import com.uzum.mms.dto.request.MerchantRequest;
import com.uzum.mms.dto.request.UpdateMerchantRequest;
import com.uzum.mms.dto.response.MerchantResponse;
import com.uzum.mms.service.MerchantService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchants")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class MerchantController {

    MerchantService merchantService;

    @PostMapping
    public ResponseEntity<MerchantResponse> create(
            @RequestBody MerchantRequest merchantRequest
    ) {
        MerchantResponse response = merchantService.create(merchantRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MerchantResponse> getById(
            @PathVariable Long id
    ) {
        MerchantResponse response = merchantService.getById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateMerchantById(
            @PathVariable Long id,
            @RequestBody UpdateMerchantRequest request
    ) {
        merchantService.updateMerchantById(id, request);
        return ResponseEntity.ok("Merchant with id " + id + " updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable Long id
    ) {
        merchantService.deleteById(id);
        return ResponseEntity.ok("Merchant deactivated with id " +id);
    }

}