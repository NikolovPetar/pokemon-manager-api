package com.demo.projects.exception.handler;

import com.demo.projects.dto.error.ErrorDTO;
import com.demo.projects.enums.PlayerErrorMessage;
import com.demo.projects.exception.BaseException;
import com.demo.projects.exception.NotFoundException;
import com.demo.projects.exception.util.ExceptionUtils;
import com.demo.projects.exception.util.StringMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    public final String appName = "player-api";

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ErrorDTO handleNotFound(NotFoundException e) {
        return ExceptionUtils.buildError(e, appName);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handleConstraintViolationException(MethodArgumentNotValidException e) {
        var invalidDetails = new HashMap<String, String>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            invalidDetails.put(StringMapper.toSnakeCase(error.getField()), error.getDefaultMessage());
        }
        for (ObjectError error : e.getBindingResult().getGlobalErrors()) {
            invalidDetails.put(StringMapper.toSnakeCase(error.getObjectName()), error.getDefaultMessage());
        }
        return ExceptionUtils.buildError(
                new BaseException(PlayerErrorMessage.ARGUMENT_NOT_VALID, e, invalidDetails), appName);
    }
}
