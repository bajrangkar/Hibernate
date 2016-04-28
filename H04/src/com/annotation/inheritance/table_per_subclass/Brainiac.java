package com.annotation.inheritance.table_per_subclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Brainiac domain class
 * @author bkar
 */
@Entity
@Table(name="1brainiac")
@PrimaryKeyJoinColumn(name="sroll")
public class Brainiac extends YellowTagged {
	
	@Column(name="rbcount")
	private long readBookCount;
	
	@Column(name="ytcount")
	private int yellowTeethCount;
	
	@Column(name="gbbf")
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