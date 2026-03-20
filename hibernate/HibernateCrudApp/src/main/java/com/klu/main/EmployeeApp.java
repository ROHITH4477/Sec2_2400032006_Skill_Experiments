package com.klu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klu.entity.Employee;
import com.klu.entity.Product;

public class EmployeeApp {

    public static void main(String[] args) {

        // Load Hibernate configuration
        Configuration conf = new Configuration().configure();

        // Build SessionFactory
        SessionFactory sf = conf.buildSessionFactory();

        // ==================================================
        // INSERT PRODUCT DATA
        // ==================================================

        Product p = new Product();
        p.setPname("Bananas");
        p.setCost(2000);

        // retrieve Session object to get the connection to DB
        Session s = sf.openSession();

        // retrieve Transaction object to perform DB operation
        Transaction tx = s.beginTransaction();

        // store employee object into session first
        s.persist(p);

        // store it permanently into db
        tx.commit();

        // detached state
        s.close();

        // ==================================================
        // READ EMPLOYEE DATA
        // ==================================================

        // Open session
        //Session s = sf.openSession();

        // Open session (required before using s)
        s = sf.openSession();

        // READ Data using find()
        Employee e = s.find(Employee.class, 1);

        // Alternative approaches:
        // Employee e = s.get(Employee.class, 1001);   // Eager loading
        // Employee e = s.load(Employee.class, 1001);  // Lazy loading

        /*
         * Difference between get() and load():
         *
         * get():
         * - Immediately hits the database
         * - Returns actual object if record exists
         * - Returns null if record does not exist
         *
         * load():
         * - Returns proxy object (lazy loading)
         * - Hits DB only when object data is accessed
         * - Throws ObjectNotFoundException if record does not exist
         */

        /* Begin transaction
        Transaction tx = s.beginTransaction();
        //Open session
        Session s = sf.openSession();

        if (e != null) {

            e.setEmail("rohithkumar@gmail.com");
            e.setEname("rohith kumar");

            s.merge(e);

        } else {
            System.out.println("Employee with ID 1 not found in database");
        }

        tx.commit();
        */

        // ==================================================
        // DELETE EMPLOYEE DATA
        // ==================================================

        // delete
        // retrieve db record
        e = s.find(Employee.class, 1);

        // to delete permanently retrieve transaction object
        tx = s.beginTransaction();
        if (e != null) {
            s.remove(e);
        }
        tx.commit();

        // retrieve session object to get the connection to db session s
        // retrive transaction object to perform db operation
        // store employee object into session first
        // store it permanently into db

        // Close session and SessionFactory
        s.close();
        sf.close();
    }
}
