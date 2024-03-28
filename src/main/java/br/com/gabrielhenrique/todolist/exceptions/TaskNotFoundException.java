package br.com.gabrielhenrique.todolist.exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(){
        super("Task não encontrada");
    }
}
