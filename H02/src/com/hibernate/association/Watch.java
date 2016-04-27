package com.hibernate.association;

/**
 * Domain class attached to Student - One to Many - Join Table - Unidirectional
 * @author bkar
 *
 */
public class Watch {

	private int watchId;
	private String watchType;
	private String watchBrand;

	public Watch() {
		super();
	}

	public Watch(String watchType, String watchBrand) {
		super();
		this.watchType = watchType;
		this.watchBrand = watchBrand;
	}

	public int getWatchId() {
		return watchId;
	}

	public void setWatchId(int watchId) {
		this.watchId = watchId;
	}

	public String getWatchType() {
		return watchType;
	}

	public void setWatchType(String watchType) {
		this.watchType = watchType;
	}

	public String getWatchBrand() {
		return watchBrand;
	}

	public void setWatchBrand(String watchBrand) {
		this.watchBrand = watchBrand;
	}

	@Override
	public String toString() {
		return "Watch("+watchId+")";
	}
	
}
