package com.todo.service;

import java.util.List;

import com.todo.dto.TaskDTO;
import com.todo.dto.TaskSavedDTO;
import com.todo.dto.TaskUpdateDTO;

public interface TaskService {
	TaskDTO saveTask(TaskSavedDTO taskSavedDTO);//create new task
	TaskDTO getTaskById(Long id);//Fetch Task by id
	List<TaskDTO> getAllTasks();//Fetch all tasks
	List<TaskDTO> getTasksByEmployeeId(Long employeeId); // Fetch tasks assigned to an employee
	TaskDTO updateTask(Long id, TaskUpdateDTO taskUpdateDTO);//update an existing task
	void deleteTask(Long id);//delete a task by an ID


}
