package com.andrew.service;

import com.andrew.dao.CheckListDao;
import com.andrew.entities.CheckList;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckListService {
    private CheckListDao checkListDao;

    public CheckList getCheckList(int id, String name) {
        System.out.println(checkListDao.getCheckList(id, name));
        return checkListDao.getCheckList(id, name);
    }
}
