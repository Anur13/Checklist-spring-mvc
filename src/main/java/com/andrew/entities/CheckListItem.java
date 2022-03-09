package com.andrew.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CheckListItem {
    private String content;
    private boolean completed;
    private int checkListId;
    private String checkListName;
}
