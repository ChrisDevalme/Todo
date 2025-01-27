package com.todo2.controllers;

import com.todo2.models.Todo;
import com.todo2.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping ("todo/")

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



}
