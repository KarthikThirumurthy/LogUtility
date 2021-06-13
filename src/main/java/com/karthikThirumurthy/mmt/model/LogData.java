package com.karthikThirumurthy.mmt.model;

import java.sql.Timestamp;
/**
 * Model POJO to hold each LogData from the File
 * @author KarthikThirumurthy
 *
 */
public class LogData {
	
	
	private String pfm;
	private String level;	
	private String step;
	private Timestamp timestamp;
	public String getPfm() {
		return pfm;
	}
	public void setPfm(String pfm) {
		this.pfm = pfm;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
