package com.example.order;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private long userId;
    private long productId;
    private Date createdAt;
}
