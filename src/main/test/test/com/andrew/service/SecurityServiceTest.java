package test.com.andrew.service;

import com.andrew.dao.jdbc.JdbcUserDao;
import com.andrew.exception.InvalidTokenException;
import com.andrew.security.Token;
import com.andrew.service.SecurityService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SecurityServiceTest {
    SecurityService securityService = new SecurityService();

    static final int ID_FOR_TOKEN = 10;
    static final int EXPIRE_TIME = 10;


    @Test
    void checkThatTokenExpires() {
        Token token = securityService.createToken(ID_FOR_TOKEN);
        token.setExpireTime(EXPIRE_TIME);
        Exception exception =
                assertThrows(InvalidTokenException.class,
                        () -> securityService.validateAndGetIdFromToken(token.getValue()));
        assertEquals("Token has expired.", exception.getMessage());
    }

    @Test
    void checkThatTokenPasses() {
        Token token = securityService.createToken(ID_FOR_TOKEN);
        token.setExpireTime(Long.MAX_VALUE);
        assertEquals(ID_FOR_TOKEN, securityService.validateAndGetIdFromToken(token.getValue()));
    }
}