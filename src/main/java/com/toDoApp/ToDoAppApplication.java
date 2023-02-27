package com.toDoApp;

import com.toDoApp.task.TaskRepository;
import com.toDoApp.users.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@EnableAutoConfiguration
public class ToDoAppApplication {

	private final TaskRepository taskRepository;
	private final UserRepository userRepository;

	public ToDoAppApplication(TaskRepository taskRepository, UserRepository userRepository) {
		this.taskRepository = taskRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}




}
