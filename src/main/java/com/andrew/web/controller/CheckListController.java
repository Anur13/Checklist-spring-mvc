package com.andrew.web.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/checklist")
@AllArgsConstructor
public class CheckListController {

//
//    @GetMapping
//    public String getChecklist(HttpServletResponse response) throws IOException {
//        return "bla";
//    }
}
