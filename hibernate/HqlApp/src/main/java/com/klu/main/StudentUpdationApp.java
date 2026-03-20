package com.klu.main;
import com.klu.entity.Student;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class StudentUpdationApp {
  public static void main(String[] args) {

    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    Session s = sf.openSession();
    Transaction tx = s.beginTransaction();

	/*
	 * String hqlUpdate =
	 * "Update Student SET fees = fees + 1000 Where course = :course"; MutationQuery
	 * query = s.createMutationQuery(hqlUpdate); query.setParameter("course",
	 * "Java"); int res = query.executeUpdate(); if(res > 0) {
	 * System.out.println("Updated Records:" + res); } else {
	 * System.out.println("No records updated"); } s.close();
	 * 
	 * String hqlDelete = "Delete from Student Where course = :course"; s =
	 * sf.openSession(); tx = s.beginTransaction(); MutationQuery query1 =
	 * s.createMutationQuery(hqlDelete); query1.setParameter("course", "MongoDB");
	 * int res1 = query1.executeUpdate(); System.out.println(res1);
	 * 
	 * s.close();
	 */

    // inserting more than one record into student table: 2nd approach
    String name = null;
    String course = null;
    double fees = 0.0;
    Student st = null;

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter No of records to be inserted: ");
    int nr = sc.nextInt();
    sc.nextLine(); // ⭐ FIX: consume leftover newline

    for (int i = 1; i <= nr; i++) {

    	System.out.println("Enter Student Name: ");
    	name = sc.nextLine();

    	System.out.println("Enter Student Course: ");
    	course = sc.nextLine();

    	System.out.println("Enter Student Course fees: ");
    	fees = sc.nextDouble();
    	sc.nextLine(); // consume newline after double

    	// create student object
    	st = new Student();

    	// calling setters to initialize student data
    	st.setName(name);
    	st.setCourse(course);
    	st.setFees(fees);

    	s.persist(st);
    }

    tx.commit();   
    s.close();
    sf.close();
    sc.close();
  }
}
