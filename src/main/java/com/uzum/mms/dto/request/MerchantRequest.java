package com.uzum.mms.dto.request;

import com.uzum.mms.constant.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record MerchantRequest(
        @NotBlank(message = "company name is blank")
        @Size(min = 2, max = 200)
        String companyName,

        @NotBlank(message = "inn is blank")
        String inn,

        @NotBlank(message = "login is blank")
        @Size(min = 4, max = 50)
        String login,

        @NotBlank(message = "password is blank")
        @Size(min = 6, max = 100)
        String password,

        @NotNull(message = "first account id is blank")
        UUID firstAccountId,

        @NotNull(message = "second account id is blank")
        UUID secondAccountId
) {
}
