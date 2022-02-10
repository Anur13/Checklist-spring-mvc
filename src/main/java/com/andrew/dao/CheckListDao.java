package com.andrew.dao;

import com.andrew.entities.CheckList;

public interface CheckListDao {

     CheckList getCheckList(int id, String name);
}
