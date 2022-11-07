package com.example.seller;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SellerConfig {
    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.order}")
    private String orderQueue;

    @Value("${rabbitmq.routing-keys.internal-order}")
    private String internalOrderRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue(this.orderQueue);
    }

    @Bean
    public Binding internalToNotificationBinding(){
        return BindingBuilder
                .bind(orderQueue())
                .to(internalTopicExchange())
                .with(this.internalOrderRoutingKey);
    }

    public String getInternalExchange() {
        return internalExchange;
    }

    public String getOrderQueue() {
        return orderQueue;
    }

    public String getInternalOrderRoutingKey() {
        return internalOrderRoutingKey;
    }
}
