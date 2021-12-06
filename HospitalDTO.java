package com.xwork.clone.hospital;

public class HospitalDTO implements Cloneable {

	private String hospitalName;
	private int hospitalId;
	private int noOfDoctors;
	private String location;
	private String specilization;
	
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public int getNoOfDoctors() {
		return noOfDoctors;
	}
	public void setNoOfDoctors(int noOfDoctors) {
		this.noOfDoctors = noOfDoctors;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}
	@Override
	public String toString() {
		return "HospitalDTO [hospitalName=" + hospitalName + ", hospitalId=" + hospitalId + ", noOfDoctors="
				+ noOfDoctors + ", location=" + location + ", specilization=" + specilization + "]";
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
