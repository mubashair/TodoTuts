package com.todo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", length = 50, updatable = false, nullable = false)
	private Long employeeId;
	@Column(name = "employee_name", length = 100, nullable = false)
	private String employeeName;
	@Column(name = "address", length = 255)
	private String address;
	@Column(name = "mobile", length = 15, nullable = false, unique = true)
	private String mobile;
	@Column(name = "active_state", nullable = false)
	private boolean activestate;
	 // One Employee can have multiple Tasks
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	//cascade = CascadeType.ALL – If an Employee is deleted, all related tasks are deleted.
	//orphanRemoval = true – If a task is removed from the list, it will be deleted from the database.
	private List<Task> tasks = new ArrayList<>(); // An employee can have multiple tasks

	
	public Employee() {
		
	}
	
	public Employee(Long employeeid, String employeename, String address, String mobile, boolean activestate) {
		super();
		this.employeeId = employeeid;
		this.employeeName = employeename;
		this.address = address;
		this.mobile = mobile;
		this.activestate = activestate;
	}
	/**
     * Constructor excluding the employeeId, used for creating new employees.
     */
	public Employee(String employeename, String address, String mobile, boolean activestate) {
		super();
		this.employeeName = employeename;
		this.address = address;
		this.mobile = mobile;
		this.activestate = activestate;
	}

	public Long getEmployeeid() {
		return employeeId;
	}
	public String getEmployeename() {
		return employeeName;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return mobile;
	}
	public boolean isActivestate() {
		return activestate;
	}
	public void setEmployeeid(Long employeeid) {
		this.employeeId = employeeid;
	}
	public void setEmployeename(String employeename) {
		this.employeeName = employeename;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setActivestate(boolean activestate) {
		this.activestate = activestate;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeId + ", employeename=" + employeeName + ", address=" + address
				+ ", mobile=" + mobile + ", activestate=" + activestate + "]";
	}
	
	

}
