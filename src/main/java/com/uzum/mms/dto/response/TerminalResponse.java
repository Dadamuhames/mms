package com.uzum.mms.dto.response;

import com.uzum.mms.constant.enums.Status;
import com.uzum.mms.entity.MerchantEntity;

public record TerminalResponse(
        Long id,

        MerchantEntity merchantId,

        String webhookUrl,

        Status terminalStatus
) {
}
