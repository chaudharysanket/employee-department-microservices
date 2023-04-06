package com.mcs.employeedetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mcs.employeedetails.entity.Department;

@FeignClient(name="department-details")
public interface DepartmentService {

	@GetMapping("/department/{id}")
	@LoadBalanced
	ArrayList<Department> getDepartmentById(@PathVariable("id") int id);
	
}
