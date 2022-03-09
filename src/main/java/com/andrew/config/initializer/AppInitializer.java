package com.andrew.config.initializer;

import com.andrew.web.filter.SecurityFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) {
        WebApplicationContext webAppContext = getWebAppContext();
        WebApplicationContext rootAppContext = getRootWebConfig();

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(webAppContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/checklist");

        servletContext.addListener(new ContextLoaderListener(rootAppContext));

        FilterRegistration filterRegistration = servletContext.addFilter("security Filter", SecurityFilter.class);
        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
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