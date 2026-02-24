package com.uzum.mms.dto.request;

import com.uzum.mms.constant.enums.Status;
import com.uzum.mms.entity.MerchantEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TerminalRequest(
        @NotNull(message = "merchant id is blank")
        MerchantEntity merchantId,

        @NotBlank(message = "webhook url is blank")
        String webhookUrl,

        @NotBlank(message = "terminal status is blank")
        Status terminalStatus
) {
}
