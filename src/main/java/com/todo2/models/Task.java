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
}
