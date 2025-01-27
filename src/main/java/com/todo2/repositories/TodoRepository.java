package com.todo2.repositories;

import com.todo2.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Todo, Integer> {
}
