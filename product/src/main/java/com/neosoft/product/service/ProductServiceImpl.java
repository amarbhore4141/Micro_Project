package com.neosoft.product.service;

import com.neosoft.product.GlobalProductException.ProductNotFoundException;
import com.neosoft.product.entity.Product;
import com.neosoft.product.model.ProductRequest;
import com.neosoft.product.model.ProductResponse;
import com.neosoft.product.repo.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Long addProduct(ProductRequest productRequest) {
        log.info("Adding Product in Service");
        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        Product savedProduct = productRepo.save(product);
        log.info("Product saved to repository : Service");

        return savedProduct.getId();
    }

    @Override
    public List<Product> getAllProduct() {
        log.info("Showing all Products : Service");
        return productRepo.findAll();

    }

    @Override
    public ProductResponse getProductById(long id) {
        log.info("Service : fetching Data by id :" + id);
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id not found"));

        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        return productResponse;
    }

    @Override
    public String deleteProductById(long id) {
        productRepo.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public void updateProductById(long id, ProductRequest updateRequest) {
        Optional<Product> byId = productRepo.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            product = product.builder()
                    .id(id)
                    .productName(updateRequest.getProductName())
                    .price(updateRequest.getPrice())
                    .quantity(updateRequest.getQuantity())
                    .build();
            productRepo.save(product);
        }
    }


}
