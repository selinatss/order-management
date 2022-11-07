package com.example.product;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductDto productDto) {
        String logMessage = "ProductService - saveProduct";
        log.info(logMessage + " started.");
        Product product = convertToEntity(productDto);
        productRepository.save(product);
        log.info(logMessage + "finished.");
    }

    public boolean isRegisteredProduct(Long productId) {
        String logMessage = "ProductService - isRegisteredProduct";
        boolean isRegisteredProduct = false;
        log.info(logMessage + " started.");
        isRegisteredProduct = productRepository.existsById(productId);
        log.info(logMessage + "finished.");
        return isRegisteredProduct;
    }

    private Product convertToEntity(ProductDto productDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(productDto, Product.class);
    }
}
