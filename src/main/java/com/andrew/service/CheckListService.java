package com.andrew.service;

import com.andrew.dao.CheckListDao;
import com.andrew.entities.CheckList;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CheckListService {
    private CheckListDao checkListDao;

    public List<CheckList> getCheckList(int id) {
//        System.out.println(checkListDao.getCheckList(id, name));
        return checkListDao.getCheckLists(id);
    }

    public void createChecklist(String name, String userId) {
        checkListDao.createChecklist(name, userId);
    }
}
