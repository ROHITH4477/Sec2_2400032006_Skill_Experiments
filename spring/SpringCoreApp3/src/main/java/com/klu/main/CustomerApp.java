package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.beans.Customer;

public class CustomerApp {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    Customer cust = context.getBean("cust",Customer.class);
    cust.getCustomerDetails();
  }
}