package com.andrew.security;

import lombok.Data;

@Data
public class Token {
    private String value;
    private long expireTime;

    public Token(String value, long expireTime) {
        this.value = value;
        this.expireTime = expireTime;
    }
}
