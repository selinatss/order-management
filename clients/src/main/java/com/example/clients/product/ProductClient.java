package com.example.clients.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product")
public interface ProductClient {
    @GetMapping("api/v1/product/{productId}")
    ProductCheckResponse isRegisteredProduct(@PathVariable("productId") Long productId);
}
