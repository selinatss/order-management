package com.example.clients.order;

import java.util.Date;

public record OrderRequest(
        Long customerId,
        Long productId,
        Long orderId,
        Date createdAt
) {}
