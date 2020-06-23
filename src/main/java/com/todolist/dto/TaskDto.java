package com.todolist.dto;

import com.todolist.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskDto {
    private Integer id;
    private Status status;
    private String name;
    private String description;
}
