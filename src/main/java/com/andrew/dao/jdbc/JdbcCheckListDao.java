package com.andrew.dao.jdbc;

import com.andrew.dao.CheckListDao;
import com.andrew.dao.jdbc.mapper.CheckListMapper;
import com.andrew.entities.CheckList;
import com.andrew.entities.CheckListItem;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcCheckListDao implements CheckListDao {

    private final JdbcTemplate jdbcTemplate;

    private CheckListMapper checkListMapper = new CheckListMapper();


    private final String GET_CHECKLIST_BY_ID = "SELECT * FROM checkListItems WHERE checkListId =" +
            " (SELECT id FROM checkLists WHERE userId = ? AND name = ?)";

    @Override
    public CheckList getCheckList(int id, String name) {
        List<CheckListItem> items = jdbcTemplate.query(GET_CHECKLIST_BY_ID, checkListMapper, id, name);
        return CheckList.builder()
                .name(name)
                .items(items)
                .build();
    }
}
//SELECT * FROM checkListItems WHERE checkListId = (SELECT id FROM checkLists WHERE userId = 1 AND name = 'First checklist');