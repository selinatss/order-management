package com.example.order;

import com.example.amqp.RabbitMQMessageProducer;
import com.example.clients.product.ProductCheckResponse;
import com.example.clients.product.ProductClient;
import com.example.clients.order.OrderRequest;
import com.example.clients.user.UserCheckResponse;
import com.example.clients.user.UserClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private UserClient userClient;
    private ProductClient productClient;
    private RabbitMQMessageProducer rabbitMQMessageProducer;

    public void saveOrder(OrderDto orderDto){
        validateParameters(orderDto);
        String logMessage = "OrderService - saveOrder";
        try {
            log.info(logMessage + " started.");
            Order order = new Order();
            order.setUserId(orderDto.getUserId());
            order.setProductId(orderDto.getProductId());
            order.setCreatedAt(new Date());
            order.setCreatedAt(new Date());
            order = orderRepository.save(order);
            OrderRequest orderRequest = new OrderRequest(order.getUserId(), order.getUserId(),
                                                           order.getId(), order.getCreatedAt());


            rabbitMQMessageProducer.publish(
                     orderRequest,
                    "internal.exchange",
                    "internal.order.routing-key"
            );
        }catch (Exception e){
            log.error("OrderService - an error occurred");
            throw e;

        }
    }

    private void validateParameters(OrderDto orderDto) {
        UserCheckResponse userCheckResponse = userClient.isRegisteredUser(orderDto.getUserId());
        if(!userCheckResponse.isRegisteredUser()){
            throw new IllegalStateException("User could not found in the system");
        }

        ProductCheckResponse productCheckResponse = productClient.isRegisteredProduct(orderDto.getProductId());
        if(!productCheckResponse.isRegisteredProduct()){
            throw new IllegalStateException("Product could not found in the system");
        }
    }

}
