package com.andrew.dao.jdbc;

import com.andrew.dao.CheckListDao;
import com.andrew.dao.jdbc.jdbcUtil.CheckListCreator;
import com.andrew.dao.jdbc.mapper.CheckListItemMapper;
import com.andrew.entities.CheckList;
import com.andrew.entities.CheckListItem;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcCheckListDao implements CheckListDao {

    private final JdbcTemplate jdbcTemplate;

    private CheckListItemMapper checkListItemMapper = new CheckListItemMapper();


    private static final String GET_CHECKLIST_BY_ID = "SELECT * FROM checkLists LEFT JOIN checkListItems" +
            " ON checkListItems.checklistid = checkLists.id WHERE checkLists.userid = ?" +
            "ORDER BY checkListItems.checklistid;";

    private static final String CREATE_CHECKLIST = "INSERT INTO checkLists (name, userId) VALUES (?,?);";

    @Override
    public List<CheckList> getCheckLists(int id) {
        List<CheckListItem> items = jdbcTemplate.query(GET_CHECKLIST_BY_ID, checkListItemMapper, id);
        return CheckListCreator.createCheckList(items);
    }

    @Override
    public void createChecklist(String name, String userId) {
        jdbcTemplate.update(CREATE_CHECKLIST, name, Integer.parseInt(userId));
    }
}
