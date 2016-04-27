package com.hibernate.inheritance;

/**
 * RedTagged domain class
 * @author bkar
 *
 */
public class RedTagged extends PrimarySchool {
	private int rcount;
	private String fname;
	private int fightfought;
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