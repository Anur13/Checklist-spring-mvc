package com.andrew.web.controller;


import com.andrew.DTO.ChecklistDto;
import com.andrew.entities.CheckList;
import com.andrew.service.CheckListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
//@RequestMapping("list")
@RequiredArgsConstructor
public class CheckListController {
    private final CheckListService checkListService;

    private int id;

    @GetMapping("/all")
    public List<CheckList> getChecklist(HttpServletRequest request) {
        id = (int) request.getAttribute("id");
        return checkListService.getCheckList(id);
    }

    @PostMapping("/add")
    public void createChecklist(HttpServletRequest request, @RequestBody ChecklistDto checklistDto) {
        String userId = request.getAttribute("id").toString();
        checkListService.createChecklist(checklistDto.getName(), userId);
    }
}
