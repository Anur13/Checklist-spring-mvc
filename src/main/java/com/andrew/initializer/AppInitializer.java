package com.andrew.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        WebApplicationContext webAppContext = getWebAppContext();
        WebApplicationContext rootAppContext = getRootWebConfig();

        servletContext.addListener(new ContextLoaderListener(rootAppContext));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(webAppContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }

    private AnnotationConfigWebApplicationContext getWebAppContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.andrew.config.WebApp");
        return context;
    }

    private AnnotationConfigWebApplicationContext getRootWebConfig() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.andrew.config.App");
        return context;
    }

}