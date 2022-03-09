package com.andrew.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class UserService {

    @Autowired
    private SecurityService securityService;

    public String login(String login, String password) {
        return securityService.login(login, password);
    }

    public String register(String login, String password) {
        return securityService.register(login, password);
    }
}
