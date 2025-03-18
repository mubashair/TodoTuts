package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.EmployeeDTO;
import com.todo.dto.EmployeeSaveDTO;
import com.todo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO){
		 EmployeeDTO saveEmployee = employeeService.saveEmployee(employeeSaveDTO);
		 return ResponseEntity.ok(saveEmployee);
	}

}
