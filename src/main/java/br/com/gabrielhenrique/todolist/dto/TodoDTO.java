package br.com.gabrielhenrique.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TodoDTO {

    @NotBlank(message = "O campo name não pode estar vazio")
    private String name;
    @NotBlank(message = "O campo description não pode estar vazio")
    private String description;
    @NotNull(message = "O campo done não pode estar vazio")
    private boolean done;
    @NotNull(message = "O campo priotity não pode estar vazio")
    private int priority;

}
