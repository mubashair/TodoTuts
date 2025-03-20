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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isActiveState() {
		return activeState;
	}

	public void setActiveState(boolean activeState) {
		this.activeState = activeState;
	}
    
    
}


