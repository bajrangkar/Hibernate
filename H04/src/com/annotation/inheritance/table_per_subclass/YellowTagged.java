package com.annotation.inheritance.table_per_subclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * YellowTagged domain class
 * @author bkar
 */
@Entity
@Table(name="1ytagged")
@PrimaryKeyJoinColumn(name="sroll")
public class YellowTagged extends PrimarySchool {
	
	@Column(name="yroll")
	private int yroll;
	
	@Column(name="yname")
	private String yname;
	
	@Column(name="bworm")
	private boolean bookworm;
	
	@Column(name="eyequeue")
	private int iq;

	public YellowTagged(String sname, String gender, int proll, String beltcolor, String tiecolor, int yroll,
			String yname, boolean bookworm, int iq) {
		super(sname, gender, proll, beltcolor, tiecolor);
		this.yroll = yroll;
		this.yname = yname;
		this.bookworm = bookworm;
		this.iq = iq;
	}

	public YellowTagged() {
		super();
	}

	public int getYroll() {
		return yroll;
	}

	public void setYroll(int yroll) {
		this.yroll = yroll;
	}

	public String getYname() {
		return yname;
	}

	public void setYname(String yname) {
		this.yname = yname;
	}

	public boolean isBookworm() {
		return bookworm;
	}

	public void setBookworm(boolean bookworm) {
		this.bookworm = bookworm;
	}

	public int getIq() {
		return iq;
	}

	public void setIq(int iq) {
		this.iq = iq;
	}
	
	
}
