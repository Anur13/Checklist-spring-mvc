package com.andrew.web.filter;

import com.andrew.exception.InvalidTokenException;
import com.andrew.service.SecurityService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class SecurityFilter extends GenericFilterBean {
    private WebApplicationContext webApplicationContext;
    private SecurityService securityService;
    private String token;
    private int id;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (webApplicationContext == null) {
            ServletContext servletContext = request.getServletContext();
            webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        }

        final Map<String, AbstractUrlHandlerMapping> beans =
                webApplicationContext.getBeansOfType(AbstractUrlHandlerMapping.class);

        securityService = webApplicationContext.getBean(SecurityService.class);

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String path = httpServletRequest.getRequestURI();

        if (path.equals("/checklist/login") || path.equals("/checklist/register")) {
            chain.doFilter(request, response);
            return;
        }

        try {
            token = httpServletRequest.getHeader("Authorization").split(" ")[1];
            id = securityService.validateAndGetIdFromToken(token);
            if (token == null) {
                httpServletResponse.sendError(401, "The token is missing.");
            } else {
                httpServletRequest.setAttribute("id", id);
                chain.doFilter(httpServletRequest, httpServletResponse);
            }

        } catch (InvalidTokenException e) {
            httpServletResponse.sendError(401, e.getMessage());
        }
    }
}
