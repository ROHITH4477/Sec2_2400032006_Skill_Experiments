package com.klu.beans;

public class Product {
  private int pid;
  private String pname;
  private double price;
  
  //constructor approach to inject dependencies of type primitive
  public Product(int pid, String pname, double price) {
    super();
    this.pid = pid;
    this.pname = pname;
    this.price = price;
  }
  
  public void getProductDetails() {
    System.out.println("Product ID:" + pid);
    System.out.println("Product Name:" + pname);
    System.out.println("Product Price:" + price);
  }
}