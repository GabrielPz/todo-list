package br.com.gabrielhenrique.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.gabrielhenrique.todolist.entity.Todo;
import br.com.gabrielhenrique.todolist.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> create(){
        return list();
    }
    public List<Todo> update(){
        return list();
    }
    public List<Todo> list(){
        Sort sort = Sort.by("priority").descending().and(
            Sort.by("name").ascending()
        );
        return todoRepository.findAll(sort);
    }
    public List<Todo> delete(){
        return list();
    }
}
