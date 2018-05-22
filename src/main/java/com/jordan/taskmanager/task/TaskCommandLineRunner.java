package com.jordan.taskmanager.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class TaskCommandLineRunner implements CommandLineRunner {
	
	private final TaskRepository repository;
	
	public TaskCommandLineRunner(TaskRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		Stream.of("Task 1", "Task 2", "Task 3", "Task 4", "Task 5", "Task 6", "Task 7").forEach(name -> repository.save(new Task(name)));
		repository.findAll().forEach(System.out::println);
	}
}
