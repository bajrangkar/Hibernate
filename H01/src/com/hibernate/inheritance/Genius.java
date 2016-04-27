package com.hibernate.inheritance;

/**
 * Genius domain class
 * @author bkar
 *
 */
public class Genius extends YellowTagged {
	private int getDumpedCount;
	private int crushCount;
	private int crashCount;

	public Genius(String sname, String gender, int proll, String beltcolor, String tiecolor, int yroll, String yname,
			boolean bookworm, int iq, int getDumpedCount, int crushCount, int crashCount) {
		super(sname, gender, proll, beltcolor, tiecolor, yroll, yname, bookworm, iq);
		this.getDumpedCount = getDumpedCount;
		this.crushCount = crushCount;
		this.crashCount = crashCount;
	}

	public Genius() {
		super();
	}

	public int getGetDumpedCount() {
		return getDumpedCount;
	}

	public void setGetDumpedCount(int getDumpedCount) {
		this.getDumpedCount = getDumpedCount;
	}

	public int getCrushCount() {
		return crushCount;
	}

	public void setCrushCount(int crushCount) {
		this.crushCount = crushCount;
	}

	public int getCrashCount() {
		return crashCount;
	}

	public void setCrashCount(int crashCount) {
		this.crashCount = crashCount;
	}

}