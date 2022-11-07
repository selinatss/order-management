package com.example.user;

import com.example.clients.user.UserCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "api/v1/user/")
public record UserController(UserService userService) {
    @PostMapping
    public void registerUser(@RequestBody UserDto userDto){
        log.info("UserController - registerUser");
        userService.registerUser(userDto);
    }
    
    @GetMapping("{userId}")
    public UserCheckResponse isRegistered(@PathVariable("userId") Long userId){
        log.info("UserController - isRegistered");
        return new UserCheckResponse(userService.isRegisteredUser(userId));
    }
}
