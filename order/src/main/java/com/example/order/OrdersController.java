package com.example.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/order")
@AllArgsConstructor
public class OrdersController{
    private OrderService orderService;

    @PostMapping
    public void saveOrder(@RequestBody OrderDto orderDto){
        log.info("OrderController - new order request received.");
        orderService.saveOrder(orderDto);
    }
}
