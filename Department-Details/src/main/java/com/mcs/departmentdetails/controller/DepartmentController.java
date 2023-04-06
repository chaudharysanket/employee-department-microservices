package com.mcs.departmentdetails.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mcs.departmentdetails.entity.Department;
import com.netflix.discovery.converters.Auto;

@RestController
public class DepartmentController {

	private List<Department> dList = Stream
			.of(new Department(9, "Risk Mgmt", List.of(1, 2, 34, 5)), 
					new Department(8, "HR", List.of(3, 4)),
					new Department(7, "Admin", List.of(1)), 
					new Department(6, "DB", List.of(2,5)))
			.collect(Collectors.toList());

	@GetMapping("/department")
	public List<Department> getAllDepartments() {
		List<Department> newDList=new ArrayList<>();
		newDList.addAll(dList);
		return newDList;
	}

	@GetMapping("/department/{eId}")
	public List<Department> getDepartmentByEId(@PathVariable("eId") int eId) {
		// return
		// dList.stream().filter(item->item.getDeptId()==id).collect(Collectors.toList());
		// System.out.println("dept list "+dList);
		return dList.stream().filter(item -> item.geteId().contains(eId)).collect(Collectors.toList());
	}

}
