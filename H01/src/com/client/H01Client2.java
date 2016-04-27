package com.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.collection.Student;
import com.hibernate.util.HibernateUtil;

/**
 * Client code for persisting domain class having complex Collection variables
 * @author bkar
 *
 */
public class H01Client2 {
	public static void main(String[] args) {
		Transaction tx = null;
		SessionFactory sf = null;
		Session session = null;
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();

			String courses[] = { "Java", "JDBC", "JSP", "JPA", "Hibernate", "EJB" };
			List<String> emails = new ArrayList<String>();
			emails.add("aa@j2ee.com");
			emails.add("bb@j2ee.com");
			emails.add("bb@j2ee.com");
			List<Integer> marks = new ArrayList<Integer>();
			marks.add(new Integer(700));
			marks.add(new Integer(699));
			marks.add(new Integer(800));
			Set<Long> phones = new HashSet<Long>();
			phones.add(new Long(232323));
			phones.add(new Long(112233));
			phones.add(new Long(123456));
			Map<String, Long> refers = new HashMap<String, Long>();
			refers.put("aaa", new Long(464646));
			refers.put("bbb", new Long(224466));
			refers.put("ccc", new Long(246810));
			Student stud = new Student("J2EE", "10-10-10", "B.Sc.", courses, emails, marks, phones, refers);
			Integer in = (Integer) session.save(stud);
			int sid = in.intValue();
			System.out.println(sid);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
			sf.close();
		}
	}
}
