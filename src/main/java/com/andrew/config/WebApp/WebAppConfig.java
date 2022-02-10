package com.andrew.config.WebApp;

import com.andrew.service.CheckListService;
import com.andrew.web.controller.CheckListController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.andrew.web")

public class WebAppConfig implements WebMvcConfigurer {


//    public CheckListController getCheckListController() {
//        return new CheckListController(new CheckListService());
//    }

}
