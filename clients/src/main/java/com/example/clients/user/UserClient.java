package com.example.clients.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user")
public interface UserClient {
     @GetMapping("api/v1/user/{userId}")
     UserCheckResponse isRegisteredUser(@PathVariable("userId") Long userId);

}
