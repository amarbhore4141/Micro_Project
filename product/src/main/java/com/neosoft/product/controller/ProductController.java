package com.neosoft.product.controller;

import com.neosoft.product.entity.Product;
import com.neosoft.product.model.ProductRequest;
import com.neosoft.product.model.ProductResponse;
import com.neosoft.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Long> addProduct(@Valid @RequestBody ProductRequest productRequest) {
        log.info("Controller layer: Data received" + productRequest.toString());
        Long id = productService.addProduct(productRequest);
        log.info("Product Added successfully: Controller");
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProduct() {

        return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id) {
        log.info("Fetching Data for id: " + id + " In Product Controller");
        return new ResponseEntity<ProductResponse>(productService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable long id) {
        log.info("Deleting Data for id: " + id);
        return new ResponseEntity<String>(productService.deleteProductById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable long id, @RequestBody ProductRequest updateRequest) {
        log.info("Updating Data for id: " + id);
        productService.updateProductById(id, updateRequest);
        return null;
    }

    @PutMapping("/reducequantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity) {
        log.info("reducing quantity " + quantity +"for id:"+ productId);
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
