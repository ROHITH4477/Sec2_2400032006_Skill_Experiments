package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.klu.beans.Student;
import com.klu.config.AppConfig;

public class StudentApp {
  public static void main(String[] args) {
	  
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    Student s = context.getBean(Student.class);
    
    s.getStudentDetails();
  }
}