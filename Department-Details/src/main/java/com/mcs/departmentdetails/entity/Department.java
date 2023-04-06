package com.mcs.departmentdetails.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Department {

	private int deptId;
	private String deptName;
	private List<Integer> eId;
	
	
	@JsonIgnore
	public List<Integer> geteId() {
		return eId;
	}
	public void seteId(List<Integer> eId) {
		this.eId = eId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Department(int deptId, String deptName,List<Integer> eId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.eId=eId;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
