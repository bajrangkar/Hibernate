package com.annotation.inheritance.table_per_concreteclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PrimarySchool domain class
 * @author bkar
 */
@Entity
@Table(name="3pschool")
public class PrimarySchool extends Student {
	
	@Column(name="proll")
	private int proll;
	
	@Column(name="bcolor")
	private String beltcolor;
	
	@Column(name="tcolor")
	private String tiecolor;

	public PrimarySchool(String sname, String gender, int proll, String beltcolor, String tiecolor) {
		super(sname, gender);
		this.proll = proll;
		this.beltcolor = beltcolor;
		this.tiecolor = tiecolor;
	}

	public PrimarySchool() {
		super();
	}

	public int getProll() {
		return proll;
	}

	public void setProll(int proll) {
		this.proll = proll;
	}

	public String getBeltcolor() {
		return beltcolor;
	}

	public void setBeltcolor(String beltcolor) {
		this.beltcolor = beltcolor;
	}

	public String getTiecolor() {
		return tiecolor;
	}

	public void setTiecolor(String tiecolor) {
		this.tiecolor = tiecolor;
	}
}