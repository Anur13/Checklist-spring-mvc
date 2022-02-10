package com.andrew.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CheckList {
    private String name;
    private List<CheckListItem> items;
}
