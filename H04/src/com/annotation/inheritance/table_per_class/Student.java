package com.annotation.inheritance.table_per_class;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
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
@Table(name="2student")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="disc")
@DiscriminatorValue(value="Student")
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
