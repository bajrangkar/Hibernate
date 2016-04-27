package com.hibernate.association;

import java.util.Set;

/**
 * Domain class Student
 * 
 * @author bkar
 *
 */
public class Student {

	private int sid;
	private String sname;
	
	// One To One - Primary Key - Bidirectional
	private Nick nick;
	
	// One To One - Foreign Key - Bidirectional
	private Address address;
	
	// Many To One/One To Many - Bidirectional
	private School school;
	
	// One To One - Join Table - Bidirectional
	private Bike bike;

	// Many To One/One To Many - Bidirectional
	private Game game;
	
	// Many To Many - Bidirectional
	private Set<Account> accounts; 
	
	public Student() {
		super();
	}

	public Student(String sname) {
		super();
		this.sname = sname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Nick getNick() {
		return nick;
	}

	public void setNick(Nick nick) {
		this.nick = nick;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	
}
