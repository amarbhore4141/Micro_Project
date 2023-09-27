package com.neosoft.product.GlobalProductException;

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
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
//        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(errorResponse.getErrorCode()));
        return ResponseEntity.status(errorResponse.getErrorCode()).body(errorResponse);

    }
}
