package com.example.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void registerUser(UserDto userDto){
        String logMessage = "UserService - registerUser";
        log.info(logMessage + " started.");
        User user = convertToUser(userDto);
        userRepository.save(convertToUser(userDto));
        log.info(logMessage + " finished. ");
    }

    public boolean isRegisteredUser(Long customerId){
        String logMessage = "UserService - isRegisteredUser";
        boolean isRegisteredUser = false;
        try{
            log.info(logMessage + " started.");
            isRegisteredUser = userRepository.existsById(customerId);
            log.info(logMessage + " finished. ");
        }catch (Exception e){
            log.error(logMessage + " an error occured.");
            throw e;
        }
        return isRegisteredUser;
    }

    private User convertToUser(UserDto userDto){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDto, User.class);
    }
}
