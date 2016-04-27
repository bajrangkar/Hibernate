package com.hibernate.inheritance;

/**
 * HighSchool domain class
 * @author bkar
 *
 */
public class HighSchool extends Student {
	private int hroll;
	private String hname;
	private String game;
	private boolean inlove;
	private int arrestcount;

	public HighSchool(String sname, String gender, int hroll, String hname, String game, boolean inlove,
			int arrestcount) {
		super(sname, gender);
		this.hroll = hroll;
		this.hname = hname;
		this.game = game;
		this.inlove = inlove;
		this.arrestcount = arrestcount;
	}

	public HighSchool() {
		super();
	}

	public int getHroll() {
		return hroll;
	}

	public void setHroll(int hroll) {
		this.hroll = hroll;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public boolean isInlove() {
		return inlove;
	}

	public void setInlove(boolean inlove) {
		this.inlove = inlove;
	}

	public int getArrestcount() {
		return arrestcount;
	}

	public void setArrestcount(int arrestcount) {
		this.arrestcount = arrestcount;
	}
}