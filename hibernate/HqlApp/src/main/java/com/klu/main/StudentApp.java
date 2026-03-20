package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.klu.entity.Student;

public class StudentApp {
  public static void main(String[] args) {
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    Session s = sf.openSession();

    // HQL: Fetch data using where clause by using named parameter
    String hql = "From Student where fees >= :fee";

    Query<Student> query = s.createQuery(hql, Student.class);
    query.setParameter("fee", 10000);
    List<Student> resultList = query.getResultList();
    System.out.println("Student Details:");
    resultList.forEach(st -> System.out.println(st));
    s.close();

    // HQL: Fetch data using where clause by using named parameter
    String hql1 = "From Student where course = ?1 and fees >= ?2";
    s = sf.openSession();
    Query<Student> query1 = s.createQuery(hql1, Student.class);
    query1.setParameter(1,"FSD");
    query1.setParameter(2, 10000);
    List<Student> resultList1 = query1.getResultList();
    System.out.println("Student Details:");
    resultList1.forEach(st -> System.out.println(st));
    s.close();
    
    //HQL: Fetch all the data with all columns in descending order
    String hql2 = "From Student order by fees DESC";
    s = sf.openSession();
    Query<Student> query2 = s.createQuery(hql2,Student.class);
    List<Student> list = query2.getResultList();
    System.out.println("Student details in descending order:");
    //the below approach is to be followed when entity having toString() method
    list.forEach(stud -> System.out.println(stud));
    //use below approach if there is no toString() method in entity
    System.out.println("List of students in descending order using getters:");
    list.forEach(stud1 -> {
      System.out.println(stud1.getId() + "\t" + stud1.getName() + 
          "\t" + stud1.getCourse() + "\t" + stud1.getFees());
    });
    s.close();
    
    //HQL: aggregate functions
    String count = "Select Count(*) from Student";
    String avg = "Select avg(fees) from Student";
    String sum = "Select sum(fees) from Student";
    String min = "Select min(fees) from Student";
    String max = "Select max(fees) from Student";
    
    s = sf.openSession();
    Query<Long> q1 = s.createQuery(count,Long.class);
    Long countRes = q1.getSingleResult();
    System.out.println("No.of Student Records:" + countRes);
    
    Query<Double> q2 = s.createQuery(sum,Double.class);
    Double sumRes = q2.getSingleResult();
    System.out.println("Total sum of fees:" + sumRes);
    
    Query<Double> q3 = s.createQuery(avg,Double.class);
    Double avgRes = q3.getSingleResult();
    System.out.println("Total fees average:" + avgRes);
    
    Query<Double> q4 = s.createQuery(min,Double.class);
    Double minRes = q4.getSingleResult();
    System.out.println("Minimum Fees:" + minRes);
    
    Query<Double> q5 = s.createQuery(max,Double.class);
    Double maxRes = q5.getSingleResult();
    System.out.println("Maximum Fees:" + maxRes);
    
    s.close();
    
    //HQL: Pagination (displaying specific no.of records per page)
    String pagination = "From Student";
    s = sf.openSession();
    Query<Student> q6 =  s.createQuery(pagination,Student.class);
    q6.setFirstResult(0);
    q6.setMaxResults(5);
    List<Student> slist = q6.getResultList();
    slist.forEach(stud2 -> System.out.println(stud2));
    
    s.close();
    
    sf.close();
  }
}