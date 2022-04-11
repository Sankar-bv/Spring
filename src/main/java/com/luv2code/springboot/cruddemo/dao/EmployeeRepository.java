package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Employee;

@RepositoryRestResource(path = "members")
//To change the default entity name as endpoints we use @RepositoryRestResource annotation i.e. default endpoint is employees so we are changing to members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
