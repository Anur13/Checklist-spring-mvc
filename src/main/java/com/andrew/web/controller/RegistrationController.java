package com.andrew.web.controller;

import com.andrew.DTO.RegistrationDto;
import com.andrew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String register(@RequestBody RegistrationDto registrationDto) {
        return userService.register(registrationDto.getLogin(), registrationDto.getPassword());
    }
}
