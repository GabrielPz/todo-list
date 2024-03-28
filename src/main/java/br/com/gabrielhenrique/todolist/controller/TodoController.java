package br.com.gabrielhenrique.todolist.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielhenrique.todolist.service.TodoService;
import jakarta.websocket.server.PathParam;
import br.com.gabrielhenrique.todolist.dto.TodoDTO;
import br.com.gabrielhenrique.todolist.entity.Todo;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    
    List<Todo> create(@RequestBody TodoDTO todoDTO){
      return todoService.create(todoDTO); 
    };
    List<Todo> update(@RequestBody TodoDTO todoDTO){
      return todoService.update(todoDTO); 
    };
    List<Todo> list(){
      return todoService.list(); 
    };
    List<Todo> delete(@PathParam(value = "") UUID id){
      return todoService.delete(id);
    };

}
