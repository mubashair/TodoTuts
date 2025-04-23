package com.todo.dto;
//TaskSavedDTO (For Creating a Task)
public class TaskSavedDTO {
	private String title;
    private String description;
    private boolean completed;
    private Long employeeId; // To associate task with an employee
    
    
    
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
