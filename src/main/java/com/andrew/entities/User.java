package com.andrew.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String login;
    private String password;
    private int id;
}
