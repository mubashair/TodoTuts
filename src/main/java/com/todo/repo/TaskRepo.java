package com.todo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
	List<Task> findByEmployeeEmployeeId(Long employeeId);

}
