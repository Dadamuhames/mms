package com.uzum.mms.dto.response;

import com.uzum.mms.constant.enums.Status;

public record TerminalResponse(
        Long id,

        String webhookUrl,

        Status terminalStatus,

        String terminalNumber
) {
}
