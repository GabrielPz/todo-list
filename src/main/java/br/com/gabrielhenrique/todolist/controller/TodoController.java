package br.com.gabrielhenrique.todolist.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielhenrique.todolist.service.TodoService;
import jakarta.validation.Valid;
import br.com.gabrielhenrique.todolist.dto.TodoDTO;
import br.com.gabrielhenrique.todolist.entity.Todo;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    
    @PostMapping
    List<Todo> create(@Valid @RequestBody TodoDTO todoDTO){
      return todoService.create(todoDTO); 
    };

    @PutMapping("{id}")
    List<Todo> update(@PathVariable("id") UUID id, @RequestBody TodoDTO todoDTO){
      return todoService.update(id, todoDTO); 
    };

    @GetMapping
    List<Todo> list(){
      return todoService.list(); 
    };


    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") UUID id){
      return todoService.delete(id);
    };

}
