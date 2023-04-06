package com.mcs.employeedetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.mcs.employeedetails.entity.Employee;

class EmployeeControllerTest {
	
	@Test
	@Disabled
	void testGetAllEmployees2() {
		fail("Not yet implemented");
		System.out.println("testGetAllEmployees2");
	}

	@Test
	void testGetAllEmployees() {
		EmployeeController ec=new EmployeeController();
		List<Employee> eTestList = ec.eList;
		System.out.println(":::::::::::::::::: eTestList :::::::::::::::: "+eTestList);
		assertThat(eTestList).hasSizeGreaterThan(10);
	}

	@Test
	@Disabled
	void testGetEmployeeById() {
		fail("Not yet implemented");
	}

}
