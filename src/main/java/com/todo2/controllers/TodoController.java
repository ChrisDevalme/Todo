package com.todo2.controllers;

import com.todo2.models.Task;
import com.todo2.models.Todo;
import com.todo2.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping ("todo/")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity <Todo> create (@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.create(todo));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos () {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <?> deleteTodo (@PathVariable ("id") int id) {
        return ResponseEntity.ok(todoService.deleteTodo(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity <Todo> editTodo (@RequestBody Todo todo, @PathVariable ("id") int id) {
        return ResponseEntity.ok(todoService.editTodo(id, todo));
    }
    @PostMapping ("/task")
    public ResponseEntity <Todo> addTask (@RequestParam String taskName, @RequestParam int id) {
        return ResponseEntity.ok(todoService.addTask(taskName, id));
    }

}
