package com.mcs.employeedetails.entity;

import java.util.List;

public class Employee {

	private String eName;
	private int eId;
	private List<Department> eDeptList;
	
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public List<Department> geteDeptList() {
		return eDeptList;
	}
	public void seteDeptList(List<Department> eDeptList) {
		this.eDeptList = eDeptList;
	}
	public Employee(String eName, int eId) {
		super();
		this.eName = eName;
		this.eId = eId;
	}
	
	public Employee(String eName, int eId, List<Department> eDeptList) {
		super();
		this.eName = eName;
		this.eId = eId;
		this.eDeptList=eDeptList;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [eName=" + eName + ", eId=" + eId + ", eDeptList=" + eDeptList + "]";
	}

	
}
