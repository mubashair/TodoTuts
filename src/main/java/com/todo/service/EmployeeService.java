package com.todo.service;

import java.util.List;

import com.todo.dto.EmployeeDTO;
import com.todo.dto.EmployeeSaveDTO;
import com.todo.dto.EmployeeUpdateDTO;
import com.todo.entity.Employee;

public interface EmployeeService {
	EmployeeDTO getEmployeeById(Long id);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO saveEmployee(EmployeeSaveDTO employeeSaveDTO);
	EmployeeDTO updateEmployee(Long id, EmployeeUpdateDTO employeeUpdateDTO);
	void deleteEmployee(Long id);
	
}
