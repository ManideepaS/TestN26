package com.n26.stat.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.n26.stat.common.APIError;
import com.n26.stat.model.ErrorResponse;

/**
 * Global exception handler class which returns meaningful
 * error responses in case if exception is thrown in internal
 * methods
 *
 * @author Manideepa
 * @since 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(ValidationException exception){
        logger.error(exception.getMessage(), exception);
        return new ErrorResponse(exception.getErrorCode(), exception.getErrorMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception exception) {
        logger.error(exception.getMessage(), exception);
        return new ErrorResponse(APIError.UNEXPECTED_ERROR.code(), APIError.UNEXPECTED_ERROR.message());
    }
}
