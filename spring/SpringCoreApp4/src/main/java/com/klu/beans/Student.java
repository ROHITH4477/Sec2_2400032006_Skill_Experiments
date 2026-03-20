package com.klu.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
  //props
  private int sid;
  private String sname;
  private String email;
  
  private Address addr;
  public void setSid(int sid) {
    this.sid = sid;
  }
  public void setSname(String sname) {
    this.sname = sname;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  @Autowired
  public void setAddr(Address addr) {
    this.addr = addr;
  }
  
  //method to get student details
  public void getStudentDetails() {
    System.out.println("Student id:" + sid);
    System.out.println("Student Name:" + sname);
    System.out.println("Student email:" + email);
    System.out.println("Student Address:");
    addr.getAddressDetails();
  }
}