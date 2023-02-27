package com.toDoApp.task;

import com.toDoApp.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>{
}
