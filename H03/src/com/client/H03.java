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
import com.hibernate.util.HibernateUtil;

/**
 * Insert and Select Client for 
 * One To One - Primary Key - Bidirectional 
 * One To One - Foreign Key - Bidirectional 
 * One To Many/Many To One - Bidirectional 
 * One To One - Join Table - Bidirectional 
 * One To Many/Many To One - Join Table -Bidirectional 
 * Many To Many - Join Table - Bidirectional
 * @author bkar
 */
public class H03 {
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;
		try {
			sf = HibernateUtil.getSessionFactory();
			s = sf.openSession();
			tx = s.beginTransaction();
			
			// Create Domain Objects
			Student stu1 = new Student("Ram");
			Student stu2 = new Student("Shyam");
			Nick nick1 = new Nick("petV");
			Nick nick2 = new Nick("petA");
			Address address1 = new Address("street1", "city1", "state1");
			Address address2 = new Address("street2", "city2", "state2");
			School school1 = new School("ABCD", "2001");
			Bike bike1 = new Bike("1111", "Yamaha", "2001");
			Bike bike2 = new Bike("2222", "Suzuki", "2002");
			Game game1 = new Game("Cricket", "Bowler");
			Account account1 = new Account("Facebook", 124);
			Account account2 = new Account("Yahoo", 111);
			
			// Assigning the relationship from both sides
			stu1.setNick(nick1); 	// One Student To One Nick - One to One Bidirectional - Primary Key
			stu2.setNick(nick2); 	// One Student To One Nick - One to One Bidirectional - Primary Key
			nick1.setStudent(stu1);	// One Nick To One Student - One to One Bidirectional - Primary Key
			nick2.setStudent(stu2);	// One Nick To One Student - One to One Bidirectional - Primary Key
			
			stu1.setAddress(address1); // One Student To One Address - One to One Bidirectional - Foreign Key
			stu2.setAddress(address2); // One Student To One Address - One to One Bidirectional - Foreign Key
			address1.setStudent(stu1); // One Address To One Student - One to One Bidirectional - Foreign Key
			address2.setStudent(stu2); // One Address To One Student - One to One Bidirectional - Foreign Key
			
			stu1.setSchool(school1); // Many Student To One School - Many To One/One To Many Bidirectional
			stu2.setSchool(school1); // Many Student To One School - Many To One/One To Many Bidirectional
			Set<Student> setofstudents = new HashSet<Student>();
			setofstudents.add(stu1);
			setofstudents.add(stu2);
			school1.setStudents(setofstudents); // One School To Many Student - Many To One/One To Many Bidirectional
			
			stu1.setBike(bike1); 	// One Student To One Bike - One to One Bidirectional Join Table 
			stu2.setBike(bike2); 	// One Student To One Bike - One to One Bidirectional Join Table
			bike1.setStudent(stu1); // One Bike To One Student - One to One Bidirectional Join Table 
			bike2.setStudent(stu2); // One Bike To One Student - One to One Bidirectional Join Table 
			
			stu1.setGame(game1); // Many Student To One Game - Many To One/One To Many Bidirectional Join Table
			stu2.setGame(game1); // Many Student To One Game - Many To One/One To Many Bidirectional Join Table
			game1.setStudents(setofstudents); // One Game To Many Student - Many To One/One To Many Bidirectional Join Table
			
			Set<Account> setofaccounts = new HashSet<Account>();
			setofaccounts.add(account1);
			setofaccounts.add(account2);
			stu1.setAccounts(setofaccounts); 	// Many Student To Many Account - Many To Many Bidirectional Join Table
			stu2.setAccounts(setofaccounts); 	// Many Student To Many Account - Many To Many Bidirectional Join Table
//			account1.setStudents(setofstudents);// Many Account To Many Student - Many To Many Bidirectional Join Table
//			account2.setStudents(setofstudents);// Many Account To Many Student - Many To Many Bidirectional Join Table
			
			// Persist the domain objects 
			s.save(nick1);
			s.save(nick2);
			s.save(address1);
			s.save(address2);
			s.save(school1);
			s.save(bike1);
			s.save(bike2);
			s.save(account1);
			s.save(account2);
			s.save(game1);
			s.save(stu1);
			s.save(stu2);
			
			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			// Assigning the relationship in reverse direction only would be enough
			Student stu3 = new Student("Gopal");
			Student stu4 = new Student("Rahim");
			Nick nick3 = new Nick("petB");
			Nick nick4 = new Nick("petC");
			nick3.setStudent(stu3); // One Nick To One Student - One to One Bidirectional - Primary Key
			nick4.setStudent(stu4); // One Nick To One Student - One to One Bidirectional - Primary Key

			Address address3 = new Address("street3", "city3", "state3");
			Address address4 = new Address("street4", "city4", "state4");
			stu3.setAddress(address3); // One Student To One Address - One to One Bidirectional - Foreign Key
			stu4.setAddress(address4); // One Student To One Address - One to One Bidirectional - Foreign Key
			address3.setStudent(stu3); // One Address To One Student - One to One Bidirectional - Foreign Key
			address4.setStudent(stu4); // One Address To One Student - One to One Bidirectional - Foreign Key
		
			School school2 = new School("EFGH","2002");
			Set<Student> setofstudents2 = new HashSet<Student>();
			setofstudents2.add(stu3);
			setofstudents2.add(stu4);
			school2.setStudents(setofstudents2); // One School To Many Student - Many To One/One To Many Bidirectional
			
			Bike bike3 = new Bike("3333", "Kawasaki", "2011");
			Bike bike4 = new Bike("4444", "Honda", "2012");
			stu3.setBike(bike3); 	// One Student To One Bike - One to One Bidirectional Join Table 
			stu4.setBike(bike4); 	// One Student To One Bike - One to One Bidirectional Join Table
			bike3.setStudent(stu3); // One Bike To One Student - One to One Bidirectional Join Table 
			bike4.setStudent(stu4); // One Bike To One Student - One to One Bidirectional Join Table 
			
			Game game2 = new Game("Football", "Center");
//			game2.setStudents(setofstudents); // Not working - Not able to save the relationship into Join table
			stu3.setGame(game2); // Many Student To One Game - Many To One/One To Many Bidirectional Join Table
			stu4.setGame(game2); // Many Student To One Game - Many To One/One To Many Bidirectional Join Table
			
			Account account3 = new Account("MySpace", 99);
			Account account4 = new Account("Orkut", 234);
			Set<Student> setofstu1 = new HashSet<Student>();
			setofstu1.add(stu3);
			setofstu1.add(stu4);
			account3.setStudents(setofstu1); // Many Account To Many Student - Many To Many Bidirectional Join Table
			account4.setStudents(setofstu1); // Many Account To Many Student - Many To Many Bidirectional Join Table
			
			s.save(nick3);
			s.save(nick4);
			s.save(address3);
			s.save(address4);
			s.save(school2);
			s.save(bike3);
			s.save(bike4);
			s.save(game2);
			s.save(account3);
			s.save(account4);
			s.save(stu3);
			s.save(stu4);
			
			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			// Assigning the relationship in forward direction only would be enough
			// Create Domain Objects
			Student stu5 = new Student("Nilesh");
			Student stu6 = new Student("Neeraj");
			Nick nick5 = new Nick("Nilu");
			Nick nick6 = new Nick("Neru");
			Address address5 = new Address("street5", "city5", "state5");
			Address address6 = new Address("street6", "city6", "state6");
			School school3 = new School("IJKL", "2003");
			Bike bike5 = new Bike("5555", "Yamaha", "2012");
			Bike bike6 = new Bike("6666", "Suzuki", "2011");
			Game game3 = new Game("Hockey", "Back");
			Account account5 = new Account("Google", 12);
			Account account6 = new Account("Twitter", 11);
			
			stu5.setNick(nick5); // One Student To One Nick - One to One Bidirectional - Primary Key
			stu6.setNick(nick6); // One Student To One Nick - One to One Bidirectional - Primary Key
			stu5.setAddress(address5); // One Student To One Address - One to One Bidirectional - Foreign Key
			stu6.setAddress(address6); // One Student To One Address - One to One Bidirectional - Foreign Key
			stu5.setSchool(school3); // Many Student To One School - Many To One/One To Many Bidirectional
			stu6.setSchool(school3); // Many Student To One School - Many To One/One To Many Bidirectional
			stu5.setBike(bike5); // One Student To One Bike - One to One Bidirectional Join Table 
			stu6.setBike(bike6); // One Student To One Bike - One to One Bidirectional Join Table
			stu5.setGame(game3); // Many Student To One Game - Many To One/One To Many Bidirectional Join Table
			stu6.setGame(game3); // Many Student To One Game - Many To One/One To Many Bidirectional Join Table
			Set<Account> setofaccounts3 = new HashSet<Account>();
			setofaccounts3.add(account5);
			setofaccounts3.add(account6);
			stu5.setAccounts(setofaccounts3); // Many Student To Many Account - Many To Many Bidirectional Join Table
			stu6.setAccounts(setofaccounts3); // Many Student To Many Account - Many To Many Bidirectional Join Table
			
			// Persist the domain objects 
			s.save(nick5);
			s.save(nick6);
			s.save(address5);
			s.save(address6);
			s.save(school3);
			s.save(bike5);
			s.save(bike6);
			s.save(account5);
			s.save(account6);
			s.save(game3);
			s.save(stu5);
			s.save(stu6);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}

		try {
			sf = HibernateUtil.getSessionFactory();
			s = sf.openSession();
			tx = s.beginTransaction();
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~STUDENT~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Query query = s.createQuery("From Student");
			List stulist = query.list();
			for (Object obj : stulist) {
				Student stuq = (Student) obj;
				System.out.print(
					String.format("♣Student{%s|%s} \t♥Nick{%s|%s} \t♥Address{%s|%s|%s|%s] \t♥School{%s|%s|%s} "
							+ "\t♠Bike{%s|%s|%s|%s} \t♠Game{%s|%s|%s} \t♠Account[",
							stuq.getSid(), 
							stuq.getSname(), 
							stuq.getNick().getNid(), 
							stuq.getNick().getNickName(),
							stuq.getAddress().getAdid(),
							stuq.getAddress().getStreet(),
							stuq.getAddress().getCity(),
							stuq.getAddress().getState(),
							stuq.getSchool().getSchid(),
							stuq.getSchool().getName(),
							stuq.getSchool().getEstbYear(),
							stuq.getBike().getBikeId(),
							stuq.getBike().getBikeNo(),
							stuq.getBike().getBikeBrand(),
							stuq.getBike().getBikeMfd(),
							stuq.getGame().getGameId(),
							stuq.getGame().getGameName(),
							stuq.getGame().getGamePosition())
				);
				Set<Account> setOfAccounts = stuq.getAccounts();
				for (Account account : setOfAccounts) {
					System.out.print(String.format("{%s|%s|%s}",
							account.getAcctId(),
							account.getAcctType(),
							account.getContacts())
					);
				}
				System.out.println("]");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~NICK~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			query = s.createQuery("From Nick");
			List nicklist = query.list();
			for (Object obj : nicklist) {
				Nick nickq = (Nick) obj;
				System.out.println(
					String.format("♠Nick{%s|%s} \t♠Student{%s|%s}",
							nickq.getNid(),
							nickq.getNickName(),
							nickq.getStudent().getSid(),
							nickq.getStudent().getSname())
				);
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ADDRESS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			query = s.createQuery("From Address");
			List addresslist = query.list();
			for (Object obj : addresslist) {
				Address addressq = (Address) obj;
				System.out.println(
					String.format("♠Address{%s|%s|%s|%s} \t♠Student{%s|%s}",
							addressq.getAdid(),
							addressq.getStreet(),
							addressq.getCity(),
							addressq.getState(),
							addressq.getStudent().getSid(),
							addressq.getStudent().getSname())
				);
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~SCHOOL~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			query = s.createQuery("From School");
			List schoollist = query.list();
			for (Object obj : schoollist) {
				School schoolq = (School) obj;
				System.out.print(
					String.format("♠School{%s|%s|%s} \t♠Student[",
							schoolq.getSchid(),
							schoolq.getName(),
							schoolq.getEstbYear(),
							schoolq.getStudents())
				);
				Set<Student> setOfStudents = schoolq.getStudents();
				for (Student st : setOfStudents) {
					System.out.print(
						String.format("{%s|%s}",
								st.getSid(),
								st.getSname())
					);
				}
				System.out.println("]");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BIKE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			query = s.createQuery("From Bike");
			List bikelist = query.list();
			for (Object obj : bikelist) {
				Bike bikeq = (Bike) obj;
				System.out.println(
					String.format("♠Bike{%s|%s|%s|%s} \t♠Student{%s|%s}",
							bikeq.getBikeId(),
							bikeq.getBikeNo(),
							bikeq.getBikeBrand(),
							bikeq.getBikeMfd(),
							bikeq.getStudent().getSid(),
							bikeq.getStudent().getSname())
				);
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~GAME~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			query = s.createQuery("From Game");
			List gamelist = query.list();
			for (Object obj : gamelist) {
				Game gameq = (Game) obj;
				System.out.print(
					String.format("♠Game{%s|%s|%s} \t♠Student[",
							gameq.getGameId(),
							gameq.getGameName(),
							gameq.getGamePosition(),
							gameq.getStudents())
				);
				Set<Student> setOfStudents = gameq.getStudents();
				for (Student st : setOfStudents) {
					System.out.print(
						String.format("{%s|%s}",
								st.getSid(),
								st.getSname())
					);
				}
				System.out.println("]");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ACCOUNT~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			query = s.createQuery("From Account");
			List accountlist = query.list();
			for (Object obj : accountlist) {
				Account accountq = (Account) obj;
				System.out.print(
					String.format("♠Game{%s|%s|%s} \t♠Student[",
							accountq.getAcctId(),
							accountq.getAcctType(),
							accountq.getContacts(),
							accountq.getStudents())
				);
				Set<Student> setOfStudents = accountq.getStudents();
				for (Student st : setOfStudents) {
					System.out.print(
						String.format("{%s|%s}",
								st.getSid(),
								st.getSname())
					);
				}
				System.out.println("]");
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
