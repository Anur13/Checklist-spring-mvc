package com.andrew.dao;

import com.andrew.entities.CheckList;

import java.util.List;

public interface CheckListDao {

    List<CheckList> getCheckLists(int id);

    void createChecklist(String name, String userId);
}
