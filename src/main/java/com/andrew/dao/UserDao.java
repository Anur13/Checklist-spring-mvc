package com.andrew.dao;

import com.andrew.entities.User;

public interface UserDao {
    void register(String login, String password);

    User login(String login);
}
