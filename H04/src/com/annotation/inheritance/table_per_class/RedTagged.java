package com.annotation.inheritance.table_per_class;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RedTagged domain class
 * @author bkar
 */
@Entity
@Table(name="1rtagged")
@DiscriminatorValue(value="RTagged")
public class RedTagged extends PrimarySchool {
	
	@Column(name="rcount")
	private int rcount;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="ff")	
	private int fightfought;

	@Column(name="tb")
	private int toothbroken;

	public RedTagged(String sname, String gender, int proll, String beltcolor, String tiecolor, int rcount,
			String fname, int fightfought, int toothbroken) {
		super(sname, gender, proll, beltcolor, tiecolor);
		this.rcount = rcount;
		this.fname = fname;
		this.fightfought = fightfought;
		this.toothbroken = toothbroken;
	}

	public RedTagged() {
		super();
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFightfought() {
		return fightfought;
	}

	public void setFightfought(int fightfought) {
		this.fightfought = fightfought;
	}

	public int getToothbroken() {
		return toothbroken;
	}

	public void setToothbroken(int toothbroken) {
		this.toothbroken = toothbroken;
	}

}