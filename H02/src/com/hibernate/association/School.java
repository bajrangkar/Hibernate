package com.hibernate.association;

/**
 * Doamin class attached to Student - One to One - Foreign Key - Unidirectional
 * @author bkar
 *
 */
public class School {
	private int sid;
	private String name;
	private String estbYear;

	public School() {
		super();
	}

	public School(String name, String estbYear) {
		super();
		this.name = name;
		this.estbYear = estbYear;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEstbYear() {
		return estbYear;
	}

	public void setEstbYear(String estbYear) {
		this.estbYear = estbYear;
	}

}
