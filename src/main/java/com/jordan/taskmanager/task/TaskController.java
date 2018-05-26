package com.jordan.taskmanager.task;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TaskController {
	private TaskRepository repository;
	private Long parentID;
	
	public TaskController(TaskRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/test-tasks")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Task> testTasks() {
		return repository.findAll().stream().filter(this::isTest).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<Task> getTask(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	
	@PutMapping(value = "/update")
	@CrossOrigin(origins = "http://localhost:4200")
	public Task putTask(@RequestBody Task t) {
		Task task = repository.findById(t.getId()).orElseThrow(() -> new ResourceNotFoundException(t.getName()));
		task.setName(t.getName());
		repository.save(task);
		return task;
	}
	
	@GetMapping("/get-children/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Task> getChildren(@PathVariable("id") Long id) {
		this.parentID = id;
		return repository.findAll().stream().filter(this::isChild).collect(Collectors.toList());
	}
	
	private boolean isTest(Task task) {
		return !task.getName().equals("Task 1") &&
				!task.getName().equals("Task 2") &&
				!task.getName().equals("Task 4");
	}
	
	private boolean isChild(Task task) {
		boolean result = task.getParentID().equals(this.parentID);
		return result;
	}
}
