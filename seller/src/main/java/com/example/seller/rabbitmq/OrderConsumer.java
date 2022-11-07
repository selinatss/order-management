package com.example.seller.rabbitmq;


import com.example.clients.order.OrderRequest;
import com.example.seller.SellerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class OrderConsumer {
    private final SellerService sellerService;

    @RabbitListener(queues = "${rabbitmq.queues.order}")
    public void consumer(OrderRequest orderRequest){
        log.info("Consumed {} from queue", orderRequest);
        sellerService.saveDelivery(orderRequest);
    }

}