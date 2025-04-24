package com.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.TaskDTO;
import com.todo.dto.TaskSavedDTO;
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

}
