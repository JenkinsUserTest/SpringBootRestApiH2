package com.yash.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDBQuery {
/*
 * selectEmployeeQuery=select emp_id,emp_name,emp_salary,emp_designation from emp
insertEmployeeQuery=insert into emp(emp_id,emp_name,emp_salary,emp_designation) values(?,?,?,?)
updateEmployeeQuery=update emp set emp_salary=? where emp_id=?
deleteEmployeeQuery=delete from  emp where emp_id=?
selectEmployeeIDQuery=select * from emp where emp_id=?
selectEmployeeDesignationQuery=select designationname from designationtable
checkEmpIdQuery=select emp_id from emp where emp_id=?
 */
	
	public EmployeeDBQuery() {}
	
	@Value("${selectEmployeeQuery}")
	private String selectEmployeeQuery;
	
	@Value("${insertEmployeeQuery}")
	private String insertEmployeeQuery;
	
	@Value("${updateEmployeeQuery}")
	private String updateEmployeeQuery;
	

	@Value("${deleteEmployeeQuery}")
	private String deleteEmployeeQuery;
	

	@Value("${selectEmployeeIDQuery}")
	private String selectEmployeeIDQuery;
	
	@Value("${selectEmployeeDesignationQuery}")
	private String selectEmployeeDesignationQuery;
	
	@Value("${checkEmpIdQuery}")
	private String checkEmpIdQuery;

	public String getSelectEmployeeQuery() {
		return selectEmployeeQuery;
	}

	public String getInsertEmployeeQuery() {
		return insertEmployeeQuery;
	}

	public String getUpdateEmployeeQuery() {
		return updateEmployeeQuery;
	}

	public String getDeleteEmployeeQuery() {
		return deleteEmployeeQuery;
	}

	public String getSelectEmployeeIDQuery() {
		return selectEmployeeIDQuery;
	}

	public String getSelectEmployeeDesignationQuery() {
		return selectEmployeeDesignationQuery;
	}

	public String getCheckEmpIdQuery() {
		return checkEmpIdQuery;
	}

	@Override
	public String toString() {
		return "EmployeeDBQuery [selectEmployeeQuery=" + selectEmployeeQuery + ", insertEmployeeQuery="
				+ insertEmployeeQuery + ", updateEmployeeQuery=" + updateEmployeeQuery + ", deleteEmployeeQuery="
				+ deleteEmployeeQuery + ", selectEmployeeIDQuery=" + selectEmployeeIDQuery
				+ ", selectEmployeeDesignationQuery=" + selectEmployeeDesignationQuery + ", checkEmpIdQuery="
				+ checkEmpIdQuery + "]";
	}
	
	
}
