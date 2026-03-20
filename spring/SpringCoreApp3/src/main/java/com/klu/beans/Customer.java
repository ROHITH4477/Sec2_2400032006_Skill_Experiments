package com.klu.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {
  private int cid;
  private String cname;
  private Product prod;
  
  //setter for Product using Autowired
  @Autowired
  public void setProd(Product prod) {
    this.prod = prod;
  }
  
  //setters for cid and cname
  public void setCid(int cid) {
    this.cid = cid;
  }
  public void setCname(String cname) {
    this.cname = cname;
  }
  
  //method to display customer details
  public void getCustomerDetails() {
    System.out.println("Customer id:" + cid);
    System.out.println("Customer name:" + cname);
    System.out.println("Customer Product Details:");
    prod.getProductDetails();
  }
}
