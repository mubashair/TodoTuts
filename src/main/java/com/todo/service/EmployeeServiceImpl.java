package com.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dto.EmployeeDTO;
import com.todo.dto.EmployeeSaveDTO;
import com.todo.dto.EmployeeUpdateDTO;
import com.todo.entity.Employee;
import com.todo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		Employee employee = employeeRepo.findById(id)
		.orElseThrow(()-> new RuntimeException("Employee not found with ID:"+id));
		return mapToDTO(employee);
	}
	

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		
		List<Employee> employees = employeeRepo.findAll();
		
		return employees.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO saveEmployee(EmployeeSaveDTO employeeSaveDTO) {
		Employee employee = new Employee(
				employeeSaveDTO.getEmployeeName(),
				employeeSaveDTO.getAddress(),
				employeeSaveDTO.getMobile(),
				employeeSaveDTO.isActiveState()
				);
		
		Employee savedEmployee = employeeRepo.save(employee);
		
		return mapToDTO(savedEmployee);
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
		 
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		
		
	}
	// Helper method to convert Entity to DTO
	EmployeeDTO mapToDTO(Employee employee) {
		return new EmployeeDTO(employee.getEmployeeid(), 
				employee.getEmployeename(),
				employee.getAddress(),
				employee.getMobile(),
				employee.isActivestate());
	}

}
