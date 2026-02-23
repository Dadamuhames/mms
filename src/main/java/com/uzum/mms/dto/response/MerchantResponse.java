package com.uzum.mms.dto.response;

import com.uzum.mms.constant.enums.Status;

import java.util.UUID;

public record MerchantResponse(

        Long id,

        String companyName,

        String inn,

        String login,

        Status merchantStatus,

        UUID firstAccountId,

        UUID secondAccountId
) {}