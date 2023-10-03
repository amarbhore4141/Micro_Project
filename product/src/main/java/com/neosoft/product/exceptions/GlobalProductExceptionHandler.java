package com.neosoft.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalProductExceptionHandler {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> hndelingNoProductFoundException(ProductNotFoundException productNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(productNotFoundException.getMessage());
        errorResponse.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND));
//        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(errorResponse.getErrorCode()));
        return ResponseEntity.status(HttpStatus.valueOf(errorResponse.getErrorCode())).body(errorResponse);

    }

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException exception) {
        return new ResponseEntity<>(new ErrorResponse().builder()
                .message(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);
    }
}
