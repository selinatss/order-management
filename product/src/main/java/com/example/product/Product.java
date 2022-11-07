package com.example.product;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Product {
    @Id
    @SequenceGenerator(
            name="product_id_sequence",
            sequenceName="product_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    private long id;
    private String productName;
    private double price;
    private String productType;
    private String category;
}
