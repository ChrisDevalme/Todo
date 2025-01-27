package com.todo2.services;

import com.todo2.models.Todo;
import com.todo2.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo create (Todo todo) {
        Todo todo1 = new Todo();
        todo1.setName(todo.getName());
        todo1.setTasks(null);
        return todoRepository.save(todo1);
    }

    public List<Todo> getAllTodos () {
        return todoRepository.findAll();
    }

    public String deleteTodo (int id) {
        todoRepository.deleteById(id);
        return "Todo has been deleted";
    }
}
