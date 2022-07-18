package com.demo.projects.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    private String message;
    private String code;
    private Map<String, String> invalidDetails;

    public BaseException(ErrorMessage errorMessage) {
        this(errorMessage, null, null);
    }

    public BaseException(
            ErrorMessage errorMessage, Throwable cause, Map<String, String> invalidDetails) {
        super(errorMessage.getMessage(), cause);
        this.message = errorMessage.getMessage();
        this.code = errorMessage.getCode();
        this.invalidDetails = invalidDetails;
    }

    public BaseException(ErrorMessage errorMessage, Throwable cause) {
        super(cause.getMessage(), cause);
        this.message = super.getMessage();
        this.code = errorMessage.getCode();
        this.invalidDetails = null;
    }
}
