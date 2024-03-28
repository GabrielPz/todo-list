package br.com.gabrielhenrique.todolist.dto;

import lombok.Data;

@Data
public class TodoDTO {

    private String name;
    private String description;
    private boolean done;
    private int priority;

}
