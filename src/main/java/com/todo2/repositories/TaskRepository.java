package com.todo2.repositories;

import com.todo2.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository <Task, Integer> {
}
