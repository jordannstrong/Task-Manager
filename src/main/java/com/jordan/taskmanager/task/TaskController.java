package com.jordan.taskmanager.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class TaskController {
	private TaskRepository repository;
	
	public TaskController(TaskRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/test-tasks")
	public Collection<Task> testTasks() {
		return repository.findAll().stream().filter(this::isTest).collect(Collectors.toList());
	}
	
	private boolean isTest(Task task) {
		return !task.getName().equals("Task 1") &&
				!task.getName().equals("Task 2") &&
				!task.getName().equals("Task 4");
	}
}
