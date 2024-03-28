package br.com.gabrielhenrique.todolist.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.gabrielhenrique.todolist.dto.TodoDTO;
import br.com.gabrielhenrique.todolist.entity.Todo;
import br.com.gabrielhenrique.todolist.exceptions.TaskNotFoundException;
import br.com.gabrielhenrique.todolist.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Todo> create(TodoDTO todoDTO){
        Todo todo = modelMapper.map(todoDTO, Todo.class);
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> update(UUID id, TodoDTO todoDTO){
        Todo existingTodo = todoRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException());
        modelMapper.map(todoDTO, existingTodo);
        todoRepository.save(existingTodo);
        return list();
    }
    public List<Todo> list(){
        Sort sort = Sort.by("priority").descending().and(
            Sort.by("name").ascending()
        );
        return todoRepository.findAll(sort);
    }
    public List<Todo> delete(UUID id){
        todoRepository.deleteById(id);
        return list();
    }
}
