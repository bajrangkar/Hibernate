package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.simple.Customer;
import com.hibernate.util.HibernateUtil;

/**
 * 
 * Client code to demonstrate persistence of domain class having Simple datatypes
 * @author bkar
 *
 */
public class H01Client1 {
	public static void main(String args[]) {
		Transaction tx = null;
		SessionFactory fact = null;
		Session session = null;
		try {
			fact = HibernateUtil.getSessionFactory();
			session = fact.openSession();
			tx = session.beginTransaction();
			Customer cust = new Customer("bajrang");
			Integer in = (Integer) session.save(cust);
			int inti = in.intValue();
			System.out.println(inti);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
			fact.close();
		}
	}
}