package com.annotation.inheritance.table_per_concreteclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Student domain class
 * @author bkar
 */
@Entity
@Table(name="3student")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Student {
	
	@Id
	@GenericGenerator(name="ss", strategy="increment")
	@GeneratedValue(generator="ss")
	@Column(name="sroll")
	private int sroll;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="gender")
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
