package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.klu.entity.Employee;

import jakarta.persistence.Tuple;

public class EmployeeApp {
  public static void main(String[] args) {
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    Session s = sf.openSession();
    
    
//    Employee e1 = new Employee("Rohith","rohith@gmail.com");
//    Employee e2 = new Employee("Subash","subash@gmail.com");
//    Employee e3 = new Employee("Sriram","sriram@gmail.com");
//    
//    s.persist(e1);
//    s.persist(e2);
//    s.persist(e3);
//    
//    Transaction tx = s.beginTransaction();
//    tx.commit();
    
    //HQL concept
    //1. retrieving all records with all columns
    String hql = "from Employee";
    Query<Employee> query = s.createQuery(hql, Employee.class);
    List<Employee> resultList = query.getResultList();
    //display list info using foreach method with LAMBDA
    System.out.println("Employee Details using Lambda:");
    resultList.forEach(emp -> System.out.println(emp));
    //display list info using enhanced for (foreach loop)
    System.out.println("Employee Details using foreach loop:");
    for(Employee e : resultList) {
      System.out.println("Emp Id:" + e.getId());
      System.out.println("Emp Name:" + e.getEname());
      System.out.println("Emp Email:" + e.getEmail());
      System.out.println("-----------------------------");
    }
    
    s.close();
    //2. retrieving all records with specific columns
    String hql1 = "select ename,email from Employee";
    s = sf.openSession();
    Query<Tuple> query2 = s.createQuery(hql1, Tuple.class);
    List<Tuple> resultList2 = query2.getResultList();
    System.out.println("Employee partial Details using foreach:");
    for(Tuple t :resultList2) {
      System.out.println("Emp Name:" + t.get(0));
      System.out.println("Emp Email:" + t.get(1));
      System.out.println("--------------------");
    }
    
    s.close();
    sf.close();
  }
}