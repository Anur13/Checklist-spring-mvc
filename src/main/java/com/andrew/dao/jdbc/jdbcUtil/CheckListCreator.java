package com.andrew.dao.jdbc.jdbcUtil;

import com.andrew.entities.CheckList;
import com.andrew.entities.CheckListItem;

import java.util.ArrayList;
import java.util.List;

public class CheckListCreator {

    public static List<CheckList> createCheckList(List<CheckListItem> items) {
        List<CheckList> lists = new ArrayList<>();

        List<CheckListItem> itemsFromSameChecklist = new ArrayList<>();
        for (int i = 0, itemsSize = items.size(); i < itemsSize; i++) {
            CheckListItem currentItem = items.get(i);
            int currentListId = currentItem.getCheckListId();

            if (itemsFromSameChecklist.isEmpty()) {
                itemsFromSameChecklist.add(currentItem);
                continue;
            }

            CheckListItem prevItem = items.get(i - 1);
            int prevListId = prevItem.getCheckListId();

            if (currentListId != prevListId) {
                lists.add(CheckList.builder()
                        .name(prevItem.getCheckListName())
                        .items(List.copyOf(itemsFromSameChecklist))
                        .build()
                );

                itemsFromSameChecklist.clear();
            }
            itemsFromSameChecklist.add(currentItem);

            if (i == itemsSize - 1) {
                lists.add(CheckList.builder()
                        .name(prevItem.getCheckListName())
                        .items(List.copyOf(itemsFromSameChecklist))
                        .build());
            }

        }
        return lists;
    }
}
