package com.example.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.seller",
                "com.example.amqp"
        }
)
@EnableEurekaClient
public class SellerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SellerApplication.class, args);
    }

}
