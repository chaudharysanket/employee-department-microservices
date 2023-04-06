package com.mcs.employeedetails.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mcs.employeedetails.entity.Department;

@FeignClient(name="department-details")
public interface DepartmentService {

	@GetMapping("/department/{id}")
	@LoadBalanced
	ArrayList<Department> getDepartmentById(@PathVariable("id") int id);

//	@Test
//	default void testCase() {
//		assertThat(null);
//	}
	
}
