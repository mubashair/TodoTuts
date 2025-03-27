package com.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.dto.EmployeeDTO;
import com.todo.dto.EmployeeSaveDTO;
import com.todo.dto.EmployeeUpdateDTO;
import com.todo.entity.Employee;
import com.todo.repo.EmployeeRepo;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	// Declare a final repository for Employee database operations
	private final EmployeeRepo employeeRepo;
	// Create a logger to log messages for debugging and info
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    
    

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
	 /**
     * Save a new employee.
     * This method creates a new Employee entity from the provided EmployeeSavedDTO,
     * saves it to the database, and returns the saved data as an EmployeeDTO.
     */
	@Transactional // Ensures that the database operations in this method are executed within a transaction
	@Override
	public EmployeeDTO saveEmployee(EmployeeSaveDTO employeeSaveDTO) {
		// Create a new Employee entity
		Employee employee = new Employee();
		// Set the employee's name using data from the DTO
		employee.setEmployeename(employeeSaveDTO.getEmployeeName());
		employee.setAddress(employeeSaveDTO.getAddress());
		employee.setMobile(employeeSaveDTO.getMobile());
		employee.setActivestate(employeeSaveDTO.isActiveState());
		// Save the new employee entity to the database and get the saved object
		Employee savedEmployee = employeeRepo.save(employee);
		// Convert the saved Employee entity to an EmployeeDTO and return it
		return mapToDTO(savedEmployee);
	}
	
	 /**
     * Update employee details.
     * This method updates an existing Employee's details using data from EmployeeUpdateDTO.
     * It first checks if the given ID is null, then finds the Employee by id,
     * updates its fields, saves the changes, and returns the updated data as a DTO.
     */
	@Transactional
	@Override
	public EmployeeDTO updateEmployee(Long id, EmployeeUpdateDTO employeeUpdateDTO) {
		// Log that we are updating an employee with the given id
		logger.info("Updating the employee with ID {}", id);
		// If the id is null, throw an exception immediately
		if(id == null) {
			throw new IllegalArgumentException("Employee ID must not be null ");
		}
		// Find the existing Employee by id; throw an exception if not found
		Employee existingEmployee = employeeRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Employee not found with ID:"+id));
		 // Update the employee's name, address, mobile, and active state from the DTO
		existingEmployee.setEmployeename(employeeUpdateDTO.getEmployeeName());
		existingEmployee.setAddress(employeeUpdateDTO.getAddress());
		existingEmployee.setMobile(employeeUpdateDTO.getMobile());
		existingEmployee.setActivestate(employeeUpdateDTO.isActiveState());
		// Save the updated existingEmployee entity to the database
		Employee updatedEmployee = employeeRepo.save(existingEmployee);
		// Convert the updated Employee entity to a DTO and return it
		return mapToDTO(updatedEmployee);
	}
	@Transactional
	@Override
	public void deleteEmployee(Long id) {
		logger.info("Deleting employee with ID: {}", id);
		// Check if the Employee exists; if not, throw an exception
		if(!employeeRepo.existsById(id)) {
			throw new RuntimeException("Employee not found with ID:"+id);
		}
		 // Delete the employee record from the database
		employeeRepo.deleteById(id);
		
		
	}
	/**
     * Helper method to convert an Employee entity to an EmployeeDTO.
     * This method takes an Employee entity and maps its fields to a new EmployeeDTO.
     */
	// Helper method to convert Entity to DTO
	EmployeeDTO mapToDTO(Employee employee) {
		return new EmployeeDTO(employee.getEmployeeid(), 
				employee.getEmployeename(),
				employee.getAddress(),
				employee.getMobile(),
				employee.isActivestate());
	}

}
