package com.todo2.services;

import com.todo2.models.Task;
import com.todo2.models.Todo;
import com.todo2.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Todo editTodo(int id, Todo todo) {
        Optional<Todo> foundTodo = todoRepository.findById(id);
        if(foundTodo.isPresent()) {
            foundTodo.get().setName(todo.getName());
            foundTodo.get().setTasks(todo.getTasks());
            return todoRepository.save(foundTodo.get());
        }   else {
            throw new RuntimeException("This Todo does n ot ex.ist by this specific ID: " + id);
        }
    }

    public Todo addTask(String taskName, int id) {
        Optional<Todo> foundTodo = todoRepository.findById(id);
        Task task = new Task();
        task.setName(taskName);
        task.setCompleted(false);
        if(foundTodo.isPresent()) {
            foundTodo.get().addTask(task);
            return todoRepository.save(foundTodo.get());
        }   else {
            throw new RuntimeException("This Todo does n ot ex.ist by this specific ID: " + id);
        }
    }
}
