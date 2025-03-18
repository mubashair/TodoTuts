package com.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
