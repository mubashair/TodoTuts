package com.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.TaskDTO;
import com.todo.dto.TaskSavedDTO;
import com.todo.dto.TaskUpdateDTO;
import com.todo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	/**
     * Create a new task.
     */
	@PostMapping
	public ResponseEntity<TaskDTO> createTask(@RequestBody TaskSavedDTO taskSavedDTO) {
		TaskDTO savedTaskDTO = taskService.saveTask(taskSavedDTO);
		
		return ResponseEntity.ok(savedTaskDTO);
	}
	/**
     * Get task by ID.
     */
	@GetMapping("/{id}")
	ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
		TaskDTO taskById = taskService.getTaskById(id);
		return ResponseEntity.ok(taskById);
	}
	/**
     * Update a task.
     */
	@PutMapping("/{id}")
	public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskUpdateDTO taskUpdateDTO){
		TaskDTO updatedTask = taskService.updateTask(id, taskUpdateDTO);
		return ResponseEntity.ok(updatedTask);
	}
	/**
     * Delete a task.
	 * @return 
     */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
	    taskService.deleteTask(id);
	    return ResponseEntity.noContent().build(); // 204 No Content response
	}

	
}
