package com.hibernate.inheritance;

/**
 * Student domain class
 * @author bkar
 *
 */
public class Student {
	private int sroll;
	private String sname;
	private String gender;

	public Student() {
		
	}
	public Student(String sname, String gender) {
		super();
		this.sname = sname;
		this.gender = gender;
	}

	public int getSroll() {
		return sroll;
	}

	public void setSroll(int sroll) {
		this.sroll = sroll;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
