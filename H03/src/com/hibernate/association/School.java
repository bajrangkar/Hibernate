package com.hibernate.association;

import java.util.Set;

/**
 * Doamin class attached to Student - One to Many/Many to One - Bidirectional
 * @author bkar
 *
 */
public class School {
	private int schid;
	private String name;
	private String estbYear;
	private Set<Student> students;
	
	public School() {
		super();
	}

	public School(String name, String estbYear) {
		super();
		this.name = name;
		this.estbYear = estbYear;
	}

	public int getSchid() {
		return schid;
	}

	public void setSchid(int schid) {
		this.schid = schid;
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
