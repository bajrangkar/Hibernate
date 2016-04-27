package com.annotation.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.annotation.domain.Customer;
import com.annotation.util.HibernateUtil;

/**
 * Client code to demonstrate persistence of domain class having Simple datatypes
 * @author bkar
 */
public class H04Client {
	public static void main(String args[]) {
		H04Client h1 = new H04Client();
		h1.runOne();
		h1.runTheMethod();
		h1.runTheMethod();
		h1.runTheMethod();
		h1.runTheMethod();
		H04Client h2 = new H04Client();
		h2.runTheMethod();
		h2.runTheMethod();
		h2.runTheMethod();
		h2.runTheMethod();
		System.exit(0);
	}
	
	Transaction tx = null;
	SessionFactory fact = null;
	Session session = null;
	
	public void runTheMethod() {
		for(int i=0; i<10; i++){
			try {
				fact = HibernateUtil.getSessionFactory();
				session = fact.openSession();
				tx = session.beginTransaction();
				Customer cust1 = null;
				switch(i){
					case 0 : cust1 = new Customer("Bajrang");		break;
					case 1 : cust1 = new Customer("Nilesh");		break;
					case 2 : cust1 = new Customer("Moni");			break;
					case 3 : cust1 = new Customer("Neeraj");		break;
					case 4 : cust1 = new Customer("Manasmita");		break;
					case 5 : cust1 = new Customer("Ajay");			break;
					case 6 : cust1 = new Customer("Archana");		break;
					case 7 : cust1 = new Customer("Sneha");			break;
					case 8 : cust1 = new Customer("Vivek");			break;
					case 9 : cust1 = new Customer("Subramanya");	break;
					default : cust1 = new Customer("Mr. Impossible");
				}
				String in1 = (String)session.save(cust1);
//				System.out.println(in1);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				//if (tx != null)
					//tx.rollback();
			}
		}
		
		try {
			fact = HibernateUtil.getSessionFactory();
			session = fact.openSession();
			tx = session.beginTransaction();
			Customer cust11 = new Customer("Customer11");
			Customer cust12 = new Customer("Customer12");
			Customer cust13 = new Customer("Customer13");
			Customer cust14 = new Customer("Customer14");
			Customer cust15 = new Customer("Customer15");
			Customer cust16 = new Customer("Customer16");
			Customer cust17 = new Customer("Customer17");
			
			session.save(cust11);
			session.save(cust12);
			session.save(cust13);
			session.save(cust14);
			session.save(cust15);
			session.save(cust16);
			session.save(cust17);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeIt() {
		fact.close();
//		session.close();
	}
	
	public void runOne() {
		try {
			fact = HibernateUtil.getSessionFactory();
			session = fact.openSession();
			tx = session.beginTransaction();
			Customer cust1 = new Customer("Bajrang");
			String in1 = (String)session.save(cust1);
//			System.out.println(in1);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}