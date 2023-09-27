package com.neosoft.product.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotNull
    private String productName;
    @Min(0)
    @NotNull
    private double price;
    @Min(0)
    @NotNull
    private long quantity;
}
