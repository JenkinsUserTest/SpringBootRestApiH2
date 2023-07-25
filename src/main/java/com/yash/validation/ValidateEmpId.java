package com.yash.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy =EmployeeIdValidator.class )
@Retention(RUNTIME)
@Target(FIELD)
public @interface ValidateEmpId {
	
	String message() default "Employee Already exists";
	Class<?>[]groups() default{};
	Class<? extends Payload>[]payload() default{};

}
