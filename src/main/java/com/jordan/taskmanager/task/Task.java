package com.jordan.taskmanager.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long parentId;
	private Long userCreatedId;
	private Long userAssignedId;
	private Long projectNumber;
	private String name;
	private String dueDate;
	
	public Task() {}
	
	public Task(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long Id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Task{"
				+ "id=" + id
				+ ", name='" + name + '\'' +
				'}';
	}
}
