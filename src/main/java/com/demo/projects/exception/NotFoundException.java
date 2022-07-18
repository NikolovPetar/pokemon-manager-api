package com.demo.projects.exception;

import lombok.ToString;

@ToString
public class NotFoundException extends BaseException {

  public NotFoundException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

  public NotFoundException(ErrorMessage errorMessage, Throwable cause) {
    super(errorMessage, cause, null);
  }
}
