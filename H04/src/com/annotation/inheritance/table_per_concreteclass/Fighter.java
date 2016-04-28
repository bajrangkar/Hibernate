package com.annotation.inheritance.table_per_concreteclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Fighter domain class
 * @author bkar
 */
@Entity
@Table(name="3fight")
public class Fighter extends RedTagged {
	
	@Column(name="punch")
	private int punchCount;
	
	@Column(name="kick")
	private int kickCount;
	
	@Column(name="bbc")
	private int beatenBrianiacCount;
	
	@Column(name="bgc")
	private int beatenGeniusCount;

	public Fighter(String sname, String gender, int proll, String beltcolor, String tiecolor, int rcount, String fname,
			int fightfought, int toothbroken, int punchCount, int kickCount, int beatenBrianiacCount,
			int beatedGeniusCount) {
		super(sname, gender, proll, beltcolor, tiecolor, rcount, fname, fightfought, toothbroken);
		this.punchCount = punchCount;
		this.kickCount = kickCount;
		this.beatenBrianiacCount = beatenBrianiacCount;
		this.beatenGeniusCount = beatedGeniusCount;
	}

	public Fighter() {
		super();
	}

	public int getPunchCount() {
		return punchCount;
	}

	public void setPunchCount(int punchCount) {
		this.punchCount = punchCount;
	}

	public int getKickCount() {
		return kickCount;
	}

	public void setKickCount(int kickCount) {
		this.kickCount = kickCount;
	}

	public int getBeatenBrianiacCount() {
		return beatenBrianiacCount;
	}

	public void setBeatenBrianiacCount(int beatenBrianiacCount) {
		this.beatenBrianiacCount = beatenBrianiacCount;
	}

	public int getBeatenGeniusCount() {
		return beatenGeniusCount;
	}

	public void setBeatenGeniusCount(int beatenGeniusCount) {
		this.beatenGeniusCount = beatenGeniusCount;
	}

}
