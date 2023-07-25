package com.yash.dao;

import java.util.List;

import com.yash.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee>getAllEmployees();
	Employee getEmployeeById(int empId);
	public boolean persistEmployee(Employee employee);
	public boolean updateEmployeeSalaryById(int empId,double newSalary);
	public boolean deleteEmployee(int empId);
	public List<String>getEmployeeDesignations();
	public boolean checkEmpId(int empId);
}
