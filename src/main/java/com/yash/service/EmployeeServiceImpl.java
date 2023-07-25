package com.yash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yash.dao.EmployeeDAO;
import com.yash.entity.Employee;
import com.yash.model.EmployeeRequest;
import com.yash.model.EmployeeResponse;

@Service("employeeServiceImpl")
@EnableAspectJAutoProxy
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired@Qualifier("jDBCEmployeeDAOImpl")
	private EmployeeDAO employeeDAO;

	public List<EmployeeResponse> getEmployeeResponseModels() {
		List<Employee> employeeList=employeeDAO.getAllEmployees();
		List<EmployeeResponse> employeeResponseList=new ArrayList<EmployeeResponse>();
		for(Employee employee:employeeList) {
			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setEmpId(employee.getEmpId());
			employeeResponse.setEmpName(employee.getEmpName().toUpperCase());
			employeeResponse.setEmpSalary(employee.getEmpSalary());
			employeeResponse.setEmpDesignation(employee.getEmpDesignation());
			employeeResponseList.add(employeeResponse);
		}
		return employeeResponseList;
	}

	public EmployeeResponse getEmployeeResponseModelById(int empId) {
		    Employee employee=employeeDAO.getEmployeeById(empId);
			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setEmpId(employee.getEmpId());
			employeeResponse.setEmpName(employee.getEmpName().toUpperCase());
			employeeResponse.setEmpSalary(employee.getEmpSalary());
			employeeResponse.setEmpDesignation(employee.getEmpDesignation());
		   return employeeResponse;
	}

	public String persistEmployeeRequest(EmployeeRequest employeeRequest) {
		
		Employee employee=new Employee();
		employee.setEmpId(employeeRequest.getEmpId());
		employee.setEmpName(employeeRequest.getEmpName());
		employee.setEmpSalary(employeeRequest.getEmpSalary());
		employee.setEmpDesignation(employeeRequest.getEmpDesignation());
		boolean employeeCreated=employeeDAO.persistEmployee(employee);
		if(employeeCreated)
			return "success";
		else
		return "fail";
	}

	public String updateEmployeeRequestSalary(int empId, double newSalary) {
		
		boolean employeeUpdated=employeeDAO.updateEmployeeSalaryById(empId, newSalary);
		if(employeeUpdated)
			return "success";
		else
		return "fail";
	}

	public String deleteEmployeeRequest(int empId) {
		boolean employeeDeleted=employeeDAO.deleteEmployee(empId);
		if(employeeDeleted)
			return "success";
		else
		return "fail";
	}

	@Transactional(propagation = Propagation.REQUIRED,noRollbackFor = Exception.class,readOnly = false)
	public List<String> getEmployeeDesignation() {
		
		return employeeDAO.getEmployeeDesignations();
	}

	public boolean checkEmpId(int empId) {
		return employeeDAO.checkEmpId(empId);
		
	}

}
