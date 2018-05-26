package com.jordan.taskmanager.task;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Task class creates a Task in the taskManager application.
 * 
 * A Task has a name, description, notes, category, percentage of completion, 
 * project number, due date, and priority.
 * 
 * @version 12.19.2017
 *
 */

@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long taskID;
	private Date dateDue;
	private String createdBy;
	private Long parentID;
	private Long priority;
	private String assignedUser;
	private String category;
	private String description;
	private Long projectNum;
	private String name;
	private String notes;
	private String percentComplete;

	/**
	 * Create a task
	 */
	public Task() {
	}
	
	/**
	 * Create a task
	 */
	public Task(String name) {
		this.name = name;
	}

	/**
	 * Set the ID of this task to a specified Id number
	 * @param id the ID to be set for this class
	 */
	public void setId(Long id) {
		taskID = id;
	}

	/**
	 * Get the ID for this task
	 * @return the ID for this task
	 */
	public Long getId() {
		return taskID;
	}

	/**
	 * Get the project number for this task
	 * @return the project number for this task
	 */
	public Long getProjectNum() {
		return projectNum;
	}

	/**
	 * Set the project number for this task to a specified number
	 * @param name the project number to be set for this task
	 */
	public void setProjectNum(Long name) {
		projectNum = name;
	}

	/**
	 * Get the name of this task
	 * @return the name of this task
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of this task to the specified value
	 * @param name the name to be set for this task
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the due date of this task
	 * @return the due date of this task
	 */
	public Date getDateDue() {
		return dateDue;
	}

	/**
	 * Set the due date of this task
	 * @param dateDue the due date to be set for this class
	 */
	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}

	/**
	 * Get the description of this task
	 * @return the description of this task
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of this task
	 * @param description the description to be set for this task
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the notes for this task
	 * @return the notes for this task
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Set the notes for this task
	 * @param notes the notes to be set for this task
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}


	/**
	 * Get the category of this task
	 * @return the category of this task
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set the category of this task
 * @param category the category of this task
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/**
	 * Set the percentage of how much of this task has been completed
	 * @param percent how much of this task has been completed
	 */
	public void setPercentComplete(String percent) {
		this.percentComplete = percent;
	}

	/**
	 * Get the percentage of completion of this task
	 * @return the percentage of completion
	 */
	public String getPercentComplete() {
		return percentComplete;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + taskID + " " + name;
	}

	/**
	 * Get the priority of this task
	 * @return the priority of this task
	 */
	public Long getPriority() {
		return priority;
	}

	/**
	 * Set the priority of this task
	 * @param inPriority the priority of this task
	 */
	public void setPriority(Long inPriority) {
		priority = inPriority;
	}

	/**
	 * Get the ID of the parent task
	 * @return the ID of the parent task
	 */
	public Long getParentID() {
		return parentID;
	}

	/**
	 * Set the ID of the parent task
	 * @param the ID of the parent task
	 */
	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}

}