package com.neosoft.product.service;

import com.neosoft.product.entity.Product;
import com.neosoft.product.model.ProductRequest;
import com.neosoft.product.model.ProductResponse;

import java.util.List;

public interface ProductService {
    Long addProduct(ProductRequest productRequest);

    List<Product> getAllProduct();

    ProductResponse getProductById(long id);

    String deleteProductById(long id);


    void updateProductById(long id, ProductRequest updateRequest);

    void reduceQuantity(long productId, long quantity);
}
