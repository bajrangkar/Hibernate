package com.hibernate.inheritance;

/**
 * Wicked domain class
 * @author bkar
 *
 */
public class Wicked extends RedTagged {
	private String speciality;
	private int fightOrganised;
	private int getCaught;
	private int successRate;

	public Wicked(String sname, String gender, int proll, String beltcolor, String tiecolor, int rcount, String fname,
			int fightfought, int toothbroken, String speciality, int fightOrganised, int getCaught, int successRate) {
		super(sname, gender, proll, beltcolor, tiecolor, rcount, fname, fightfought, toothbroken);
		this.speciality = speciality;
		this.fightOrganised = fightOrganised;
		this.getCaught = getCaught;
		this.successRate = successRate;
	}

	public Wicked() {
		super();
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getFightOrganised() {
		return fightOrganised;
	}

	public void setFightOrganised(int fightOrganised) {
		this.fightOrganised = fightOrganised;
	}

	public int getGetCaught() {
		return getCaught;
	}

	public void setGetCaught(int getCaught) {
		this.getCaught = getCaught;
	}

	public int getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(int successRate) {
		this.successRate = successRate;
	}

}
