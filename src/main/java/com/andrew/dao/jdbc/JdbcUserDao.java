package com.andrew.dao.jdbc;

import com.andrew.dao.UserDao;
import com.andrew.dao.jdbc.mapper.UserMapper;
import com.andrew.entities.User;
import com.andrew.exception.DuplicateUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcUserDao implements UserDao {
    private UserMapper userMapper = new UserMapper();

    private final JdbcTemplate jdbcTemplate;

    private static final String REGISTER_QUERY = "INSERT INTO users (name, password) VALUES (?,?);";
    private static final String LOGIN_QUERY = "SELECT * FROM users WHERE name = ?;";

    @Override
    public void register(String login, String password) {
        User user = login(login);
        if (user != null) {
            throw new DuplicateUserException();
        }
        jdbcTemplate.update(REGISTER_QUERY, login, password);

    }

    @Override
    public User login(String login) {
        try {
            return jdbcTemplate.queryForObject(LOGIN_QUERY, userMapper, login);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
