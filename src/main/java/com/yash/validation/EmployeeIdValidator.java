package com.yash.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yash.service.EmployeeService;
@Component
public class EmployeeIdValidator implements ConstraintValidator<ValidateEmpId,Integer>{

	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		boolean employeeFound=employeeService.checkEmpId(value);
		if(employeeFound) {
			return false;
		}
		return true;
	}

}
