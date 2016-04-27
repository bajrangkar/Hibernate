package com.hibernate.inheritance;

/**
 * Brainiac domain class
 * @author bkar
 *
 */
public class Brainiac extends YellowTagged {
	private long readBookCount;
	private int yellowTeethCount;
	private long getBeatenByFightersCount;

	public Brainiac(String sname, String gender, int proll, String beltcolor, String tiecolor, int yroll, String yname,
			boolean bookworm, int iq, long readBookCount, int yellowTeethCount, long getBeatenByFightersCount) {
		super(sname, gender, proll, beltcolor, tiecolor, yroll, yname, bookworm, iq);
		this.readBookCount = readBookCount;
		this.yellowTeethCount = yellowTeethCount;
		this.getBeatenByFightersCount = getBeatenByFightersCount;
	}

	public Brainiac() {
		super();
	}

	public long getReadBookCount() {
		return readBookCount;
	}

	public void setReadBookCount(long readBookCount) {
		this.readBookCount = readBookCount;
	}

	public int getYellowTeethCount() {
		return yellowTeethCount;
	}

	public void setYellowTeethCount(int yellowTeethCount) {
		this.yellowTeethCount = yellowTeethCount;
	}

	public long getGetBeatenByFightersCount() {
		return getBeatenByFightersCount;
	}

	public void setGetBeatenByFightersCount(long getBeatenByFightersCount) {
		this.getBeatenByFightersCount = getBeatenByFightersCount;
	}

}