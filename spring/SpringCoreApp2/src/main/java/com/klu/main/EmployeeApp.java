package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.beans.Employee;

public class EmployeeApp {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Employee emp = context.getBean("emp", Employee.class);

        System.out.println("Employee Details:");
        emp.getEmpDetails();
    }
}
