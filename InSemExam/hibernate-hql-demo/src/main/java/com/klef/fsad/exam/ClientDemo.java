package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // INSERT using persistent object
        Ticket t = new Ticket(101,"Login Issue","2026-03-10","Open");
        session.persist(t);

        tx.commit();

        // HQL UPDATE using positional parameters
        Transaction tx2 = session.beginTransaction();

        String hql = "update Ticket set name=?1, status=?2 where id=?3";

        Query<?> query = session.createQuery(hql);
        query.setParameter(1,"Payment Issue");
        query.setParameter(2,"Closed");
        query.setParameter(3,101);

        query.executeUpdate();

        tx2.commit();

        session.close();
        sf.close();
    }
}