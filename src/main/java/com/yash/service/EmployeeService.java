package com.yash.service;

import java.util.List;

import com.yash.model.EmployeeRequest;
import com.yash.model.EmployeeResponse;

public interface EmployeeService {
	
	List<EmployeeResponse>getEmployeeResponseModels();
	EmployeeResponse getEmployeeResponseModelById(int empId);
	String persistEmployeeRequest(EmployeeRequest employeeRequest);
	String updateEmployeeRequestSalary(int empId ,double newSalary);
	String deleteEmployeeRequest(int empId);
	List<String>getEmployeeDesignation();
	boolean checkEmpId(int empId);
}
