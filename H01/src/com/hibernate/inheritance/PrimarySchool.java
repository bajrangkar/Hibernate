package com.hibernate.inheritance;

/**
 * PrimarySchool domain class
 * @author bkar
 *
 */
public class PrimarySchool extends Student {
	private int proll;
	private String beltcolor;
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