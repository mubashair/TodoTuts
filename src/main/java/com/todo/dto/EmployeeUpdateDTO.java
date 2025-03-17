package com.todo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeUpdateDTO {
    private Long employeeId; // Required to identify the employee
    private String employeeName;
    private String address;
    private String mobile;
    private boolean activeState;
}
/*📌 Why Include employeeId?

When updating an employee, we need the ID to find the correct record.*/