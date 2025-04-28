package com.musinsa.backend.exception;

import com.musinsa.backend.controller.ProductController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException error, HttpServletRequest request) {
        ErrorResponse errorResponse = this.generateErrorResponse(error.getErrorCode());

        return new ResponseEntity<>(errorResponse, error.getErrorCode().getStatus());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception error, HttpServletRequest request) {
        ErrorResponse errorResponse = this.generateErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingParams(MissingServletRequestParameterException ex) {
        ErrorResponse errorResponse = this.generateErrorResponse(ErrorCode.REQUIRED_PARAMETER_MISSING);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private ErrorResponse generateErrorResponse(ErrorCode code){
        return ErrorResponse.builder()
                .status(code.getStatus().value())
                .error(code.name())
                .message(code.getMessage())
                .build();
    }
}
