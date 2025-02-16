package com.todo2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Task {

    @Id
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn (name = "todo_id")
    private Todo todo;
    private boolean completed;

    public Task() {
    }

    public Task(int id, String name, Todo todo, boolean completed) {
        this.id = id;
        this.name = name;
        this.todo = todo;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}


