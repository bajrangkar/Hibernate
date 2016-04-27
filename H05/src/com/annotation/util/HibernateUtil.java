package com.annotation.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static SessionFactory factory = null;

	static {
		try {
			//AnnotationConfiguration merged in Configuration in between Hibernate 3.2 and Hibernate 3.6
			Configuration cfg = new Configuration();
			cfg = cfg.configure();
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error in Initializing SessionFactory");
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}