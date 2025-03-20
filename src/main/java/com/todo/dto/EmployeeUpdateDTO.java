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
    
    //getters
	public Long getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
	public boolean isActiveState() {
		return activeState;
	}
	
	
	//setters
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setActiveState(boolean activeState) {
		this.activeState = activeState;
	}
    
    
}
/*📌 Why Include employeeId?

When updating an employee, we need the ID to find the correct record.*/
