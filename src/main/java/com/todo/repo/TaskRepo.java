package com.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
