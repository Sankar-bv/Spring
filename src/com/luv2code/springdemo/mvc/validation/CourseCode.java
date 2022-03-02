package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
//The above annotation is used for on which data we need to use the custom annotation
//Currently we are defining this custom annotation to be used on Fields & Methods
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//Define default course code
	public String value() default "LUV";
	
	//Define default error message
	public String message() default "must start with LUV";
	
	//Define default groups
	public Class<?>[] groups() default {};
	
	//Define default payloads
	public Class<? extends Payload>[] payload() default {};
	
}
