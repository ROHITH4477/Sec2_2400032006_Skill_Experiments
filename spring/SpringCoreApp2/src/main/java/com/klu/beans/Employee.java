package com.klu.beans;

public class Employee {
	
	//props
	private int eid;
	private String ename;
	private String desig;
	private double sal;
	private Department dept;
	public Employee(int eid, String ename, String desig, double sal, Department dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.desig = desig;
		this.sal = sal;
		this.dept = dept;
	}
	public void getEmpDetails() {
		System.out.println("Emp ID:"+ eid);
		System.out.println("Emp Name:"+ ename);
		System.out.println("Emp Designation:"+ desig);
		System.out.println("Emp Salary:"+ sal);
		dept.getDeptDetails();
	}

}
