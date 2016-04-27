package com.hibernate.association;

/**
 * Domain class attached to Student - One to One - Join Table - Unidirectional
 * @author bkar
 *
 */
public class Bike {

	private int bikeId;
	private String bikeNo;
	private String bikeBrand;
	private String bikeMfd;

	public Bike() {
		super();
	}

	public Bike(String bikeNo, String bikeBrand, String bikeMfd) {
		super();
		this.bikeNo = bikeNo;
		this.bikeBrand = bikeBrand;
		this.bikeMfd = bikeMfd;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getBikeNo() {
		return bikeNo;
	}

	public void setBikeNo(String bikeNo) {
		this.bikeNo = bikeNo;
	}

	public String getBikeBrand() {
		return bikeBrand;
	}

	public void setBikeBrand(String bikeBrand) {
		this.bikeBrand = bikeBrand;
	}

	public String getBikeMfd() {
		return bikeMfd;
	}

	public void setBikeMfd(String bikeMfd) {
		this.bikeMfd = bikeMfd;
	}

}
