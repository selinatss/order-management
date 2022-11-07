package com.example.user;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserDto {
    private String name;
    private String surname;
    private String email;
    private String password;
}
