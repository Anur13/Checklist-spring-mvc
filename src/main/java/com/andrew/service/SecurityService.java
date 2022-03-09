package com.andrew.service;

import com.andrew.dao.UserDao;
import com.andrew.entities.User;
import com.andrew.exception.InvalidTokenException;
import com.andrew.security.PasswordEncryptor;
import com.andrew.security.Token;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
public class SecurityService {
    private UserDao userDao;
    private PasswordEncryptor passwordEncryptor;


    private final Map<String, Token> TOKEN_MAP = Collections.synchronizedMap(new HashMap<>());

    public String register(String login, String password) {
        userDao.register(login, encryptPassword(password));
        return this.login(login, password);
    }

    public String login(String login, String password) {
        User user = userDao.login(login);
        if (user.getPassword().equals(encryptPassword(password))) {
            Token token = createToken(user.getId());
            return token.getValue();
        }
        return null;
    }

    public Token createToken(int id) {
        String uniqueID = UUID.randomUUID().toString();
        String token = uniqueID + '/' + id;
        long expireDate = new Date().getTime() + 3600000;
        Token newToken = new Token(token, expireDate);
        TOKEN_MAP.put(newToken.getValue(), newToken);
        return newToken;

    }

    public int getIdFromToken(String token) {
        String[] parsedToken = token.split("/");
        if (parsedToken.length < 2) {
            throw new InvalidTokenException("Invalid token");
        }
        return Integer.parseInt(parsedToken[1]);
    }


    public String encryptPassword(String password) {
        byte[] hash = passwordEncryptor.encryptPassword(password);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hash) {
            stringBuilder.append(String.valueOf(b));
        }
        return stringBuilder.toString();
    }

    private boolean validateToken(String token) {
        if (TOKEN_MAP.containsKey(token)) {
            Token currToken = TOKEN_MAP.get(token);
            long currentTime = new Date().getTime();
            return currToken.getExpireTime() > currentTime;
        }
        throw new InvalidTokenException("Token is invalid.");
    }

    public int validateAndGetIdFromToken(String token) {
        if (validateToken(token)) {
            return getIdFromToken(token);
        }
        TOKEN_MAP.remove(token);
        throw new InvalidTokenException("Token has expired.");
    }
}
