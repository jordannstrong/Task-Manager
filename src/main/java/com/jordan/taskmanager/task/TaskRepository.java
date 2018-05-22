package com.jordan.taskmanager.task;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface TaskRepository extends JpaRepository<Task, Long> {
	
}
