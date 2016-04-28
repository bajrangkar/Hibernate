package com.annotation.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.annotation.inheritance.table_per_concreteclass.Brainiac;
import com.annotation.inheritance.table_per_concreteclass.Fighter;
import com.annotation.inheritance.table_per_concreteclass.Genius;
import com.annotation.inheritance.table_per_concreteclass.HighSchool;
import com.annotation.inheritance.table_per_concreteclass.PrimarySchool;
import com.annotation.inheritance.table_per_concreteclass.RedTagged;
import com.annotation.inheritance.table_per_concreteclass.Student;
import com.annotation.inheritance.table_per_concreteclass.Wicked;
import com.annotation.inheritance.table_per_concreteclass.YellowTagged;

//import com.annotation.inheritance.table_per_class.Brainiac;
//import com.annotation.inheritance.table_per_class.Fighter;
//import com.annotation.inheritance.table_per_class.Genius;
//import com.annotation.inheritance.table_per_class.HighSchool;
//import com.annotation.inheritance.table_per_class.PrimarySchool;
//import com.annotation.inheritance.table_per_class.RedTagged;
//import com.annotation.inheritance.table_per_class.Student;
//import com.annotation.inheritance.table_per_class.Wicked;
//import com.annotation.inheritance.table_per_class.YellowTagged;

//import com.annotation.inheritance.table_per_subclass.Brainiac;
//import com.annotation.inheritance.table_per_subclass.Fighter;
//import com.annotation.inheritance.table_per_subclass.Genius;
//import com.annotation.inheritance.table_per_subclass.HighSchool;
//import com.annotation.inheritance.table_per_subclass.PrimarySchool;
//import com.annotation.inheritance.table_per_subclass.RedTagged;
//import com.annotation.inheritance.table_per_subclass.Student;
//import com.annotation.inheritance.table_per_subclass.Wicked;
//import com.annotation.inheritance.table_per_subclass.YellowTagged;

import com.annotation.util.HibernateUtil;

/**
 * Client code to demonstrate persistence of domain classes having Inheritance using 
 * 
 * 1> Table Per Subclass Inheritance Mapping 		- Change import classes in this file to run
 * 2> Table Per Class Inheritance Mapping 			- Change import classes in this file to run
 * 3> Table Per Concrete Class Inheritance Mapping 	- Change import classes in this file to run
 * @author bkar
 *
 */
public class H04InheritanceInsert {
	public static void main(String[] args) {
		Transaction tx = null;
		SessionFactory sf = null;
		Session se = null;
		try {
			sf = HibernateUtil.getSessionFactory();
			se = sf.openSession();
			tx = se.beginTransaction();
			Student student = new Student("Nilu", "Female");
			Integer in = (Integer) se.save(student);
			System.out.println(in.intValue());
			HighSchool hschool = new HighSchool("Pooja", "Female", 10003, "Khokho", "chulbul", false, 9);
			in = (Integer) se.save(hschool);
			System.out.println(in.intValue());
			PrimarySchool pschool = new PrimarySchool("Neelam", "Female", 1009, "rainbow", "lovly");
			in = (Integer) se.save(pschool);
			System.out.println(in.intValue());
			YellowTagged ytagged = new YellowTagged("Nilesh", "Male", 2009, "micheal", "jackson", 1001, "DirtyDancer", true, 1390);
			in = (Integer) se.save(ytagged);
			System.out.println(in.intValue());
			Genius genius = new Genius("Neeraj", "Male", 1300, "SkyBlue", "BabyPink", 666, "Mani", false, 1995, 17, 111, 110);
			in = (Integer) se.save(genius);
			System.out.println(in.intValue());
			Brainiac brianey = new Brainiac("Moni", "Female", 9999, "Green", "Red", 1987, "BullsEye", true, 8888, 555999, 0, 1);
			in = (Integer) se.save(brianey);
			System.out.println(in.intValue());
			RedTagged reddy = new RedTagged("Bajrang", "Male", 0007, "Red", "Red", 1100, "FireBall", 8998, 3);
			in = (Integer) se.save(reddy);
			System.out.println(in.intValue());
			Wicked wicky = new Wicked("Preeti", "Female", 9000, "Black", "Black", 9099, "Killer", 99, 9, "Teasing", 999, 999, 100);
			in = (Integer) se.save(wicky);
			System.out.println(in.intValue());
			Fighter fightnow = new Fighter("Nitu", "Female", 1111, "Purple", "Purple", 8888, "SoulSlayer", 9999, 1999, 555, 11008, 98, 99);
			in = (Integer) se.save(fightnow);
			System.out.println(in.intValue());
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			se.close();
			sf.close();
		}
	}
}
