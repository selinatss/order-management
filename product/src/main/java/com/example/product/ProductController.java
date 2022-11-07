package com.example.product;

import com.example.clients.product.ProductCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/product")
public record ProductController(ProductService productService) {
    @PostMapping
    public void saveProduct(@RequestBody ProductDto productDto){
       log.info("ProductController - saveProduct: " + productDto);
       productService.saveProduct(productDto);
    }

    @GetMapping("{productId}")
    public ProductCheckResponse isRegistered(@PathVariable("productId") Long productId){
        log.info("ProductController - isRegistered: " + productId);
        return new ProductCheckResponse(productService.isRegisteredProduct(productId));
    }
}
