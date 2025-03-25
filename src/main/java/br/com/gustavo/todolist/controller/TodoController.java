package br.com.gustavo.todolist.controller;


import br.com.gustavo.todolist.entity.Todo;
import br.com.gustavo.todolist.service.TodoService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public List<Todo> createTodo(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> listTodos() {
        return todoService.list();
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> deleteTodo(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
