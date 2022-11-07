package com.example.product;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ProductDto {
    private String productName;
    private double price;
    private String productType;
    private String category;
}
