package com.todo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.todo.dto.TaskDTO;
import com.todo.dto.TaskSavedDTO;
import com.todo.dto.TaskUpdateDTO;
import com.todo.entity.Employee;
import com.todo.repo.EmployeeRepo;
import com.todo.repo.TaskRepo;
@Service
public class TaskServiceImpl implements TaskService {
	private final TaskRepo taskRepo;
	private final EmployeeRepo employeeRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

	public TaskServiceImpl(TaskRepo taskRepo, EmployeeRepo employeeRepo) {
		this.taskRepo = taskRepo;
		this.employeeRepo = employeeRepo;
	}

	@Override
	public TaskDTO saveTask(TaskSavedDTO taskSavedDTO) {
		logger.info("Saving new task for employee ID:{}", taskSavedDTO.getEmployeeId());
		Employee employee = employeeRepo.findById(taskSavedDTO.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Employee not found with ID"+ taskSavedDTO.getEmployeeId()));
		
		return null;
	}

	@Override
	public TaskDTO getTaskById(Long id) {
		
		return null;
	}

	@Override
	public List<TaskDTO> getAllTasks() {
		
		return null;
	}

	@Override
	public List<TaskDTO> getTasksByEmployeeId(Long employeeId) {
		
		return null;
	}

	@Override
	public TaskDTO updateTask(Long id, TaskUpdateDTO taskUpdateDTO) {
		
		return null;
	}

	@Override
	public void deleteTask(Long id) {
		

	}

}
