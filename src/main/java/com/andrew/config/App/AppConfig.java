package com.andrew.config.App;

import com.andrew.dao.jdbc.JdbcCheckListDao;
import com.andrew.dao.jdbc.JdbcUserDao;
import com.andrew.security.PasswordEncryptor;
import com.andrew.service.CheckListService;
import com.andrew.service.SecurityService;
import com.andrew.service.UserService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.andrew")
@PropertySource("classpath:/app.properties")
public class AppConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Bean
    public HikariDataSource getDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(password);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public JdbcTemplate getJDBCTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public JdbcCheckListDao getJdbcCheckListDao() {
        return new JdbcCheckListDao(getJDBCTemplate());
    }

    @Bean
    public JdbcUserDao getJdbcUserDao() {
        return new JdbcUserDao(getJDBCTemplate());
    }

    @Bean
    public PasswordEncryptor getPasswordEncryptor() {
        return new PasswordEncryptor();
    }

    @Bean
    public SecurityService getSecurityService() {
        return new SecurityService(getJdbcUserDao(), getPasswordEncryptor());
    }

    @Bean
    public CheckListService getCheckListService() {
        return new CheckListService(getJdbcCheckListDao());
    }

    @Bean
    public UserService getUserService() {
        return new UserService(getSecurityService());
    }

}