package com.todo.dto;
//TaskDTO (For Returning Task Data)
public class TaskDTO {
	
	//This DTO is used to return task details to the frontend or other clients. 
	//It includes the employeeId but not the entire Employee object to keep it lightweight.
	private Long taskId;
    private String title;
    private String description;
    private boolean completed;
    // To show which employee the task belongs to
    private Long employeeId; // Reference to Employee
    
    
	public Long getTaskId() {
		return taskId;
	}
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
	public void setTaskId(Long id) {
		this.taskId = id;
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
