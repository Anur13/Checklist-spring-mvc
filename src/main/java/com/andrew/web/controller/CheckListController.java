package com.andrew.web.controller;


import com.andrew.entities.CheckList;
import com.andrew.service.CheckListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checklist")
@AllArgsConstructor
public class CheckListController {
    private CheckListService checkListService;

    @GetMapping
    public CheckList getChecklist(@RequestParam int id) {
        return checkListService.getCheckList(id, "First checklist");
    }
}
