package com.mcs.employeedetails.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mcs.employeedetails.entity.Department;
import com.mcs.employeedetails.entity.Employee;
import com.mcs.employeedetails.service.DepartmentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Resource;

@RestController
//@Log4j
public class EmployeeController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DepartmentService departmentService;
	
	//Logger log=LoggerFactory.getLogger(this.getClass());
	private static final Logger log = Logger.getLogger(EmployeeController.class);
	
	
	List<Employee> eList=Stream.of(
			new Employee("Abc", 1,List.of()),
			new Employee("Xyz", 2,List.of()),
			new Employee("Lmn", 3,List.of())
			).collect(Collectors.toList());
	
	
	public ResponseEntity<List<Employee>> getAllEmployees2(Exception e){
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
		ArrayList<Employee> fallBackEmpList=new ArrayList<>();
		fallBackEmpList.addAll(eList);
		fallBackEmpList.add(new Employee("Pqr", 4,List.of()));
		fallBackEmpList.add(new Employee("Kjl", 5,List.of()));
		log.info(":::::::::::::: In fallback method :::::::::::::: "+fallBackEmpList);
		return new ResponseEntity<List<Employee>>(fallBackEmpList,HttpStatus.OK);
	}
	
	
	@GetMapping("/employee")
	@CircuitBreaker(name="getAllEmployees", fallbackMethod = "getAllEmployees2")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		//try {
		ArrayList<Employee> empList2=new ArrayList<>();
		int id=0;
		for(Employee e:eList) {
		String url="http://department-details:9191/department/"+e.geteId();
		//ArrayList eDList = restTemplate.getForObject(url, ArrayList.class);
		ArrayList<Department> eDList = departmentService.getDepartmentById(e.geteId());
		eList.stream().filter(item->item.geteId()==e.geteId()).forEach((item)->{item.seteDeptList(eDList);empList2.add(item);});
		}
		System.out.println("emp list "+empList2.toString());
		System.out.println("e list:::: "+eList.toString());
		log.info("::::::::trying::::::::");
		
		//}catch(Exception e) {
			//log.error(":::::::: in all employees catch :::::::::");
		//}
		return new ResponseEntity<List<Employee>>(empList2,HttpStatus.OK);
	}
	
	//@SuppressWarnings("unchecked")
	@GetMapping("/employee/{id}")
	public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable("id") int id){
		String url="http://department-details:9191/department/"+id;
		//ArrayList eDList = restTemplate.getForObject(url, ArrayList.class);
		ArrayList<Department> eDList = departmentService.getDepartmentById(id);
		ArrayList<Employee> empList=new ArrayList<>();
		eList.stream().filter(item->item.geteId()==id).forEach((item)->{item.seteDeptList(eDList);empList.add(item);});
		System.out.println("emp list "+empList.toString());
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	
	
}
