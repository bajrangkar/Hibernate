package com.hibernate.association;

/**
 * Domain class attached to Student - One to One - Foreign Key - Bidirectional
 * @author bkar
 *
 */
public class Address {
	private int adid;
	private String street;
	private String city;
	private String state;
	// One To One - Foreign Key - Bidirectional
	private Student student;
	
	public Address() {
		super();
	}

	public Address(String street, String city, String state) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public int getAdid() {
		return adid;
	}

	public void setAdid(int adid) {
		this.adid = adid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}