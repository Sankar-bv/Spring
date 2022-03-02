package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {

	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to ten")
	//private int freePasses;	
	//The above line will throw error for Notnull annotation i.e cannot convert string to int.
	//So to resolve this issue we use wrapper Integer. we should replace getter and setter method data type from int to Integer
	private Integer freePasses;
	
	@Pattern(regexp="[0-9]{5}", message="only 5 digits")
//	@Pattern(regexp="[A-Za-z0-9]{5}", message="only 5 digits")  To check regular expression for alphabets and digits
	private String postalCode;
	
	@CourseCode
	//Adding custom annotation which will have default value as LUV
	//@CourseCode(value = "TOPS", message = "must start with TOPS")
	//The above custom annotation will have the value as TOPS and will throw error if the value not starts with TOPS
	private String courseCode;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}
	
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
