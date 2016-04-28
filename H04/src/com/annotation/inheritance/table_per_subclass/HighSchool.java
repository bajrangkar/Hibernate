package com.annotation.inheritance.table_per_subclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * HighSchool domain class
 * @author bkar
 */
@Entity
@Table(name="1hschool")
@PrimaryKeyJoinColumn(name="sroll")
public class HighSchool extends Student {
	
	@Column(name="hroll")
	private int hroll;
	
	@Column(name="hname")
	private String hname;
	
	@Column(name="game")
	private String game;
	
	private boolean inlove;
	
	@Column(name="acount")
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