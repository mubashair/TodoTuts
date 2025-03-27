package com.todo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.EmployeeDTO;
import com.todo.dto.EmployeeSaveDTO;
import com.todo.dto.EmployeeUpdateDTO;
import com.todo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO){
		 EmployeeDTO saveEmployee = employeeService.saveEmployee(employeeSaveDTO);
		 return ResponseEntity.ok(saveEmployee);
	}
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable Long id) {
		EmployeeDTO employeeById = employeeService.getEmployeeById(id);
		return employeeById;
	}
	@GetMapping
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	@PutMapping("/{id}")
	public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
		logger.info("Received request to update the employee with ID: {}", id);
		return employeeService.updateEmployee(id, employeeUpdateDTO);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		logger.info("Received request to delete an employee with ID: {}", id);
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted successfully!");
		
	}

}
