package com.andrew.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/*")
public class Start {

    @GetMapping
    public String test(HttpServletResponse response) throws IOException {
        response.sendError(500, "new scuces");
        return "test";
    }
}
