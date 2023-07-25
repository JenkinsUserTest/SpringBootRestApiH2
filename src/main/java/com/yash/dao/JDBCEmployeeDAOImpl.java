package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.entity.Employee;
import com.yash.helper.ConnectionManager;
import com.yash.helper.EmployeeDBQuery;
@Repository("jDBCEmployeeDAOImpl")
public class JDBCEmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private ConnectionManager connectionManager;
	@Autowired
	private EmployeeDBQuery employeeDBQuery;
	

	public List<Employee> getAllEmployees() {
		Connection connection=connectionManager.openConnection();
		List<Employee> employeeList=new ArrayList<Employee>();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(employeeDBQuery.getSelectEmployeeQuery());
			while(resultSet.next()) {
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				employee.setEmpDesignation(resultSet.getString(4));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionManager.closeConnection();
		return employeeList;
	}

	public Employee getEmployeeById(int empId) {
		Connection connection=connectionManager.openConnection();
	     Employee employee=new Employee();
		try {
			PreparedStatement statement=connection.prepareStatement(employeeDBQuery.getSelectEmployeeIDQuery());
			statement.setInt(1, empId);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				employee.setEmpDesignation(resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionManager.closeConnection();
		return employee;
	}

	public boolean persistEmployee(Employee employee) {
		Connection connection=connectionManager.openConnection();
		int rows=0;
		try {
			PreparedStatement statement=connection.prepareStatement(employeeDBQuery.getInsertEmployeeQuery());
			statement.setInt(1, employee.getEmpId());
			statement.setString(2, employee.getEmpName());
			statement.setDouble(3, employee.getEmpSalary());
			statement.setString(4, employee.getEmpDesignation());
			rows=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionManager.closeConnection();
		if(rows>0)
			return true;
		else
			return false;
	}

	public boolean updateEmployeeSalaryById(int empId, double newSalary) {
		Connection connection=connectionManager.openConnection();
		int rows=0;
		try {
			PreparedStatement statement=connection.prepareStatement(employeeDBQuery.getUpdateEmployeeQuery());
			statement.setDouble(1, newSalary);
			statement.setInt(2, empId);
			rows=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionManager.closeConnection();
		if(rows>0)
			return true;
		else
			return false;
	}

	public boolean deleteEmployee(int empId) {
		Connection connection=connectionManager.openConnection();
		int rows=0;
		try {
			PreparedStatement statement=connection.prepareStatement(employeeDBQuery.getDeleteEmployeeQuery());
			statement.setInt(1, empId);
			rows=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionManager.closeConnection();
		if(rows>0)
			return true;
		else
			return false;
	}

	public List<String> getEmployeeDesignations() {
		Connection connection=connectionManager.openConnection();
		List<String> desginationList=new ArrayList<String>();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(employeeDBQuery.getSelectEmployeeDesignationQuery());
			while(resultSet.next()) {
				
				desginationList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionManager.closeConnection();
		return desginationList;
	}

	public boolean checkEmpId(int empId) {
		Connection connection=connectionManager.openConnection();
       boolean employeeFound=false;
		try {
			PreparedStatement statement=connection.prepareStatement(employeeDBQuery.getCheckEmpIdQuery());
			statement.setInt(1, empId);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				employeeFound=true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionManager.closeConnection();
		return employeeFound;
	}

}
