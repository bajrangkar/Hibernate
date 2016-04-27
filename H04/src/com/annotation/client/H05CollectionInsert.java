package com.annotation.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.annotation.collection.Student;
import com.annotation.util.HibernateUtil;

/**
 * Client code to demonstrate persistence of domain class having Collection datatypes
 * @author bkar
 */
public class H05CollectionInsert {
	public static void main(String args[]) {
		Transaction tx = null;
		SessionFactory fact = null;
		Session session = null;
		try {
			fact = HibernateUtil.getSessionFactory();
			session = fact.openSession();
			tx = session.beginTransaction();
			Student student = new Student();
			student.setSname("Sheetal");
			student.setDob("11-01-2011");
			student.setQualification("M.Sc.");
			student.setCourses(new String[] { "A", "B", "C" });
			student.setEmails(new ArrayList<String>() {
				private static final long serialVersionUID = 1L;
				{
					add("ABC");
					add("DEF");
					add("GHI");
				}
			});
			student.setMarks(new ArrayList<Integer>() {
				private static final long serialVersionUID = 1L;
				{
					add(11);
					add(12);
					add(13);
				}
			});
			student.setPhones(new HashSet<Long>() {
				private static final long serialVersionUID = 1L;
				{
					add(new Long(1111));
					add(new Long(2222));
				}
			});
			student.setRefs(new HashMap<String, Long>() {
				private static final long serialVersionUID = 1L;
				{
					put("ABCD", new Long(11));
					put("DEFG", new Long(22));
				}
			});
			Integer in = (Integer) session.save(student);
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