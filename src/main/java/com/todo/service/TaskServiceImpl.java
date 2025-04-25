package com.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.todo.dto.TaskDTO;
import com.todo.dto.TaskSavedDTO;
import com.todo.dto.TaskUpdateDTO;
import com.todo.entity.Employee;
import com.todo.entity.Task;
import com.todo.repo.EmployeeRepo;
import com.todo.repo.TaskRepo;
//This marks the class as a Spring service. It implements the TaskService interface.
@Service
public class TaskServiceImpl implements TaskService {
	// These are the dependencies for this service class. 
	//taskRepository is used to manage tasks in the DB. employeeRepository is for employee data. 
	//logger is used for logging info/debug/error messages.
	private final TaskRepo taskRepo;
	private final EmployeeRepo employeeRepo;
	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    //Constructor-based dependency injection. Spring injects the repositories when creating this service.
	public TaskServiceImpl(TaskRepo taskRepo, EmployeeRepo employeeRepo) {
		this.taskRepo = taskRepo;
		this.employeeRepo = employeeRepo;
	}
	 

	@Override
	public TaskDTO saveTask(TaskSavedDTO taskSavedDTO) {
		//Logs the start of the task-saving process.
		logger.info("Saving new task for employee ID:{}", taskSavedDTO.getEmployeeId());
		// Looks for the employee by ID. If not found, throws an exception.
		Employee employee = employeeRepo.findById(taskSavedDTO.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Employee not found with ID:"+ taskSavedDTO.getEmployeeId()));
		//Creates a new Task entity and fills it with values from the DTO.
		Task task = new Task();
		task.setTitle(taskSavedDTO.getTitle());
		task.setDescription(taskSavedDTO.getDescription());
		task.setCompleted(taskSavedDTO.isCompleted());
		task.setEmployee(employee);// Assign task to employee
		//Saves the task to the DB and returns it as a DTO.
		Task savedTask = taskRepo.save(task);
		//and return it as a dto
		return mapToDTO(savedTask);
	}

	@Override
	public TaskDTO getTaskById(Long id) {
		logger.info("Fetching task with id {}", id);
		//Looks for the task. Throws an error if not found.
		Task task = taskRepo.findById(id)
		.orElseThrow(()->new RuntimeException("Task not found with ID:"+ id));
		//Converts entity to DTO and returns it.
		return mapToDTO(task);
	}

	@Override
	public List<TaskDTO> getAllTasks() {
		
		return null;
	}
	 /**
     * Get all tasks assigned to a specific employee.
     */
	@Override
	public List<TaskDTO> getTasksByEmployeeId(Long employeeId) {
		logger.info("Fetching task for employee ID: {}", employeeId);
		List<Task> tasks = taskRepo.findByEmployeeEmployeeId(employeeId);
		return tasks.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public TaskDTO updateTask(Long id, TaskUpdateDTO taskUpdateDTO) {
		
		return null;
	}

	@Override
	public void deleteTask(Long id) {
		

	}
	/**
     * Helper method to convert Task entity to TaskDTO.
     */
	private TaskDTO mapToDTO(Task task) {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTaskId(task.getTaskId());
		taskDTO.setTitle(task.getTitle());
		taskDTO.setCompleted(task.isCompleted());
		taskDTO.setDescription(task.getDescription());
		taskDTO.setEmployeeId(task.getEmployee().getEmployeeid());
		
		return taskDTO;
	}

}
