package com.todo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//Used for returning employee data from APIs.
public class EmployeeDTO {
    private Long employeeId;
    private String employeeName;
    private String address;
    private String mobile;
    private boolean activeState;
}

