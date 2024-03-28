package br.com.gabrielhenrique.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gabrielhenrique.todolist.dto.TodoDTO;
import br.com.gabrielhenrique.todolist.entity.Todo;
import br.com.gabrielhenrique.todolist.repository.TodoRepository;
import br.com.gabrielhenrique.todolist.service.TodoService;

@SpringBootTest
class TodoListApplicationTests {

	@InjectMocks
	private TodoService todoService;

	@Mock
	private TodoRepository todoRepository;

	@Mock
	private ModelMapper modelMapper;
	
	private TodoDTO todoDTO;
	@BeforeEach
	void setup(){
		todoDTO = new TodoDTO();
		todoDTO.setName("Task Teste");
		todoDTO.setDescription("Desc Task Test");
		todoDTO.setPriority(2);
		todoDTO.setDone(false);
	};
	
	@Test
	@DisplayName("Should create successfully")
	public void createTaskSuccess(){
		Todo expectedTodo = new Todo(); 
		when(modelMapper.map(any(TodoDTO.class), any())).thenReturn(expectedTodo);

		when(todoRepository.save(any(Todo.class))).thenReturn(expectedTodo);

		List<Todo> result = todoService.create(todoDTO);

		verify(todoRepository).save(any(Todo.class));
		assertNotNull(result);
		List<Todo> expectedList = new ArrayList<>();
		expectedList.add(expectedTodo);
		when(todoService.list()).thenReturn(expectedList);
		assertEquals(expectedList.size(), result.size());
	}
}

