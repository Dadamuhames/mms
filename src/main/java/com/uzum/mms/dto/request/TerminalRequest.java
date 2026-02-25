package com.uzum.mms.dto.request;

import com.uzum.mms.constant.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TerminalRequest(
        @NotNull(message = "merchant id is blank")
        Long merchantId,

        @NotBlank(message = "webhook url is blank")
        String webhookUrl,

        @NotNull(message = "terminal status is blank")
        Status terminalStatus,

        @NotBlank(message = "terminal number is blank")
        String terminalNumber
) {
}
