package com.klu.beans;

public class Department {

    // props
    private String deptId;
    private String deptName;

    // constructor
    public Department(String deptId, String deptName) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public void getDeptDetails() {
        System.out.println("Department ID:" + deptId);
        System.out.println("Department Name:" + deptName);
    }
}
