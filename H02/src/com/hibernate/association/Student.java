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
	// One To One - Primary Key - Unidirectional
	private Nick name;

	// One To One - Foreign Key - Unidirectional
	private School school;

	// Many To One - Unidirectional
	private Address address;

	// One To Many - Unidirectional
	private Set<Toy> toy;

	// One To One - Join Table - Unidirectional
	private Bike bike;

	// One To Many - Join Table - Unidirectional
	private Set<Watch> watch;

	// Many To One - Join Table - Unidirectional
	private Game game;
	
	// Many To Many - Join Table - Unidirectional
	private Set<Account> account;
	
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

	public Nick getName() {
		return name;
	}

	public void setName(Nick name) {
		this.name = name;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Toy> getToy() {
		return toy;
	}

	public void setToy(Set<Toy> toy) {
		this.toy = toy;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public Set<Watch> getWatch() {
		return watch;
	}

	public void setWatch(Set<Watch> watch) {
		this.watch = watch;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	
}
