package com.client;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.association.Account;
import com.hibernate.association.Address;
import com.hibernate.association.Bike;
import com.hibernate.association.Game;
import com.hibernate.association.Nick;
import com.hibernate.association.School;
import com.hibernate.association.Student;
import com.hibernate.association.Toy;
import com.hibernate.association.Watch;
import com.hibernate.util.HibernateUtil;

/**
 * Insert and Select Client for
 * One To One - Primary Key - Unidirectional
 * One To One - Foreign Key - Unidirectional
 * Many To One - Unidirectional
 * One To Many - Unidirectional 
 * One To One - Join Table - Unidirectional
 * One To Many - join Table - Unidirectional
 * Many To One - Join Table - Unidirectional
 * Many To Many - Join Table - Unidirectional
 * @author bkar
 */
public class H02Extended {
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;
		try {
			sf = HibernateUtil.getSessionFactory();
			s = sf.openSession();
			tx = s.beginTransaction();

			Student stu1 = new Student("Ram");
			Student stu2 = new Student("Shyam");
			Student stu3 = new Student("Gopal");
			Student stu4 = new Student("Rahim");
			Student stu5 = new Student("Krishna");
			s.save(stu1);
			s.save(stu2);
			s.save(stu3);
			s.save(stu4);
			s.save(stu5);
			
			Nick nick1 = new Nick("petV", "play0", true);
			Nick nick2 = new Nick("petA", "play1", true);
			Nick nick3 = new Nick("petB", "play2", true);
			Nick nick4 = new Nick("petC", "play3", true);
			Nick nick5 = new Nick("petD", "play4", true);
			s.save(nick1);
			s.save(nick2);
			s.save(nick3);
			s.save(nick4);
			s.save(nick5);

			School school1 = new School("ABV", "1956");
			School school2 = new School("CCLHS", "1922");
			School school3 = new School("RCR", "1911");
			School school4 = new School("MCR", "1900");
			School school5 = new School("BITMESRA", "1966");
			s.save(school1);
			s.save(school2);
			s.save(school3);
			s.save(school4);
			s.save(school5);
			
			Address address = new Address("18", "Bangalore", "KA");
			s.save(address);

			Set<Toy> setoftoys = null;
			for(int i=1;i<=5;i++) {
				setoftoys = new HashSet<Toy>();
				Toy toy1 = new Toy("Pig", "Pink");
				Toy toy2 = new Toy("Cat", "Brown");
				Toy toy3 = new Toy("Dog", "Black");
				s.save(toy1);
				s.save(toy2);
				s.save(toy3);
				setoftoys.add(toy1);
				setoftoys.add(toy2);
				setoftoys.add(toy3);
				
				switch(i) {
					//4. One To Many - Unidirectional
					case 1 : stu1.setToy(setoftoys); break;
					case 2 : stu2.setToy(setoftoys); break;
					case 3 : stu3.setToy(setoftoys); break;
					case 4 : stu4.setToy(setoftoys); break;
					case 5 : stu5.setToy(setoftoys); break;
				}
			}

			//1. One To One - Primary Key - Unidirectional
			stu1.setName(nick1);
			// You must have to attach a School to a Student
			// Otherwise it will throw null pointer exception while iterating, & no transaction will be committed
			stu2.setName(nick2);
			stu3.setName(nick3);
			stu4.setName(nick4);
			stu5.setName(nick5);
			
			//2. One To One - Foreign Key - Unidirectional
			stu1.setSchool(school1);
			// You must have to attach a School to a Student
			// Otherwise it will throw null pointer exception while iterating, & no transaction will be committed
			stu2.setSchool(school2);
			stu3.setSchool(school3);
			stu4.setSchool(school4);
			stu5.setSchool(school5);
			
			//3. Many To One - Unidirectional
			stu1.setAddress(address);
			stu2.setAddress(address); // Will throw FK exception in One To One
			stu3.setAddress(address); // Will throw FK exception in One To One
			stu4.setAddress(address); // Will throw FK exception in One To One
			stu5.setAddress(address); // Will throw FK exception in One To One
																			
			Bike bike1 = new Bike("1111", "Yahama", "2010");
			Bike bike2 = new Bike("2222", "Bugati", "2011");
			Bike bike3 = new Bike("3333", "Sukuki", "2012");
			Bike bike4 = new Bike("4444", "Kawasaki", "2013");
			Bike bike5 = new Bike("5555", "HD", "2015");
			s.save(bike1);
			s.save(bike2);
			s.save(bike3);
			s.save(bike4);
			s.save(bike5);
			
			//5. One To One - Join Table - Unidirectional
			stu1.setBike(bike1);
			stu2.setBike(bike2);
			stu3.setBike(bike3);
			stu4.setBike(bike4);
			stu5.setBike(bike5);
			
			Set<Watch> setofwatchs = null;
			for(int i=1;i<=5;i++) {
				setofwatchs = new HashSet<Watch>();
				Watch watch1 = new Watch("Sports","Fastrack");
				Watch watch2 = new Watch("Casual","Casio");
				Watch watch3 = new Watch("Office","Rado");
				Watch watch4 = new Watch("Swimming","Titan");
				Watch watch5 = new Watch("Unisex","Fastrack");
				s.save(watch1);
				s.save(watch2);
				s.save(watch3);
				s.save(watch4);
				s.save(watch5);
				setofwatchs.add(watch1);
				setofwatchs.add(watch2);
				setofwatchs.add(watch3);
				setofwatchs.add(watch4);
				setofwatchs.add(watch5);
				switch(i) {
					//6. One To Many - Join Table - Unidirectional
					case 1 : stu1.setWatch(setofwatchs); break;
					case 2 : stu2.setWatch(setofwatchs); break;
					case 3 : stu3.setWatch(setofwatchs); break;
					case 4 : stu4.setWatch(setofwatchs); break;
					case 5 : stu5.setWatch(setofwatchs); break;
				}
			}
			
			Game game1 = new Game("Cricket", "Batsman");
			s.save(game1);
			//7. Many To One - Join Table - Unidirectional
			stu1.setGame(game1);
			stu2.setGame(game1);
			stu3.setGame(game1);
			stu4.setGame(game1);
			stu5.setGame(game1);
			
			Set<Account> setofaccounts = null;
			Account acctAll1 = new Account("ForAll1",12);
			Account acctAll2 = new Account("ForAll2",13);
			Account acctAll3 = new Account("ForAll3",14);
			s.save(acctAll1);
			s.save(acctAll2);
			s.save(acctAll3);
			for(int i=1;i<=5;i++) {
				setofaccounts = new HashSet<Account>();
				Account account1 = new Account("Facebook", 32);
				Account account2 = new Account("Gmail", 30);
				Account account3 = new Account("Yahoo", 24);
				Account account4 = new Account("Bing", 16);
				Account account5 = new Account("MySpace", 8);
				s.save(account1);
				s.save(account2);
				s.save(account3);
				s.save(account4);
				s.save(account5);
				setofaccounts.add(account1);
				setofaccounts.add(account2);
				setofaccounts.add(account3);
				setofaccounts.add(account4);
				setofaccounts.add(account5);
				setofaccounts.add(acctAll1);
				setofaccounts.add(acctAll2);
				setofaccounts.add(acctAll3);
				switch(i) {
					//8. Many To Many - Join Table - Unidirectional
					case 1 : stu1.setAccount(setofaccounts); break;
					case 2 : stu2.setAccount(setofaccounts); break;
					case 3 : stu3.setAccount(setofaccounts); break;
					case 4 : stu4.setAccount(setofaccounts); break;
					case 5 : stu5.setAccount(setofaccounts); break;
				}
			}
			
			Query query = s.createQuery("From Student");
			List stul = query.list();
			for (Object obj : stul) {
				Student stu6 = (Student) obj;
				System.out.println("********************************"
					+ "\n Student: "+ stu6.getSid() 
					+ "\n Student: "+ stu6.getSname() 
					+ "\n Nick: "   + stu6.getName().getSid()	
					+ "\n Nick: "   + stu6.getName().getPetName()
					+ "\n Nick: "   + stu6.getName().getNatureOf()
					+ "\n Nick: "   + stu6.getName().isNaughty()
					+ "\n School: " + stu6.getSchool().getSid()
					+ "\n School: " + stu6.getSchool().getName()
					+ "\n School: " + stu6.getSchool().getEstbYear()
					+ "\n Address: "+ stu6.getAddress().getAdid() 
					+ "\n Address: "+ stu6.getAddress().getStreet() 
					+ "\n Address: "+ stu6.getAddress().getCity() 
					+ "\n Address: "+ stu6.getAddress().getState()
					+ "\n Toy: "    + stu6.getToy()
					+ "\n Bike: "   + stu6.getBike().getBikeId()
					+ "\n Bike: "   + stu6.getBike().getBikeNo()
					+ "\n Bike: "   + stu6.getBike().getBikeBrand()
					+ "\n Bike: "   + stu6.getBike().getBikeMfd()
					+ "\n Watch: "  + stu6.getWatch()
					+ "\n Game: "   + stu6.getGame().getGameId()
					+ "\n Game: "   + stu6.getGame().getGameName()
					+ "\n Game: "   + stu6.getGame().getGamePosition()
					+ "\n Account: "+ stu6.getAccount()
					);
				Set<Toy> setOfToys = stu6.getToy();
				for (Toy t : setOfToys) {
					System.out.println(
						" Toy ID : "      + t.getToyid()
						+"\t Toy Name : " + t.getToyName()
						+"\t Toy Color : "+ t.getToyColor()
					);
				}
				Set<Watch> setOfWatchs = stu6.getWatch();
				for (Watch w : setOfWatchs) {
					System.out.println(
						" Watch ID : "      + w.getWatchId()
						+"\t Watch Type : " + w.getWatchType()
						+"\t Watch Brand : "+ w.getWatchBrand()
					);
				}
				Set<Account> setOfAccounts = stu6.getAccount();
				for (Account a : setOfAccounts) {
					System.out.println(
						" Account ID : "         + a.getAcctId()
						+"\t Account Type : "    + a.getAcctType()
						+"\t Account Contacts : "+ a.getContacts()
					);
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
			sf.close();
		}
	}
}
