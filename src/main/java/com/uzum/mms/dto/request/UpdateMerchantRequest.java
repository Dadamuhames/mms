package com.uzum.mms.dto.request;

public record UpdateMerchantRequest(
        String companyName,
        String password,
        String login
) {
}
