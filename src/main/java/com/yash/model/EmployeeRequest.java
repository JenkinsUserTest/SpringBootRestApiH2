package com.yash.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.yash.validation.ValidateEmpId;


public class EmployeeRequest {
	@ValidateEmpId(message = "{com.synechron.model.EmployeeRequest.empId.error}")
	private int empId;
	@NotBlank(message= "{com.synechron.model.EmployeeRequest.empName.error}")
	private String empName;
	private double empSalary;
	@Size(max=10,min=3,message="{com.synechron.model.EmployeeRequest.empDesignation.length}")
	private String empDesignation;
	
	public EmployeeRequest() {}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empDesignation == null) ? 0 : empDesignation.hashCode());
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(empSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRequest other = (EmployeeRequest) obj;
		if (empDesignation == null) {
			if (other.empDesignation != null)
				return false;
		} else if (!empDesignation.equals(other.empDesignation))
			return false;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (Double.doubleToLongBits(empSalary) != Double.doubleToLongBits(other.empSalary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary
				+ ", empDesignation=" + empDesignation + "]";
	}

	
	
}
