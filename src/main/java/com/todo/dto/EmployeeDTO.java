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
    
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(Long employeeId, String employeeName, String address, String mobile, boolean activeState) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
		this.mobile = mobile;
		this.activeState = activeState;
	}
    
    
}


