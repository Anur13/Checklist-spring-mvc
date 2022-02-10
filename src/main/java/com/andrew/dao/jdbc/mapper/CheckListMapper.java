package com.andrew.dao.jdbc.mapper;

import com.andrew.entities.CheckListItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckListMapper implements RowMapper<CheckListItem> {
    @Override
    public CheckListItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CheckListItem.builder()
                .content(rs.getString("content"))
                .completed(rs.getBoolean("completed"))
                .build();

    }
}
