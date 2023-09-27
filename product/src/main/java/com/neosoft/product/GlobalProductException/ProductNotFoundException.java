package com.neosoft.product.GlobalProductException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductNotFoundException extends RuntimeException{
    private String errorMessage;

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
