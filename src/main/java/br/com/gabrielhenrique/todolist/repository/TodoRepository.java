package br.com.gabrielhenrique.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrielhenrique.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
    
}
