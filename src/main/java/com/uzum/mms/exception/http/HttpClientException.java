package com.uzum.mms.exception.http;

import com.uzum.mms.constant.enums.ErrorCode;
import com.uzum.mms.constant.enums.ErrorType;
import com.uzum.mms.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class HttpClientException extends ApplicationException {

    public HttpClientException(String message, HttpStatusCode status) {
        super(ErrorCode.HTTP_CLIENT_ERROR_CODE.getCode(), message, ErrorType.EXTERNAL, HttpStatus.valueOf(status.value()));
    }
}
