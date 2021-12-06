package com.xwork.clone.institute;

public class InstituteDTO implements Cloneable{

	private String instituteName;
	private int instituteId;
	private int fees;
	private String location;
	private int noOfTrainers;
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfTrainers() {
		return noOfTrainers;
	}
	public void setNoOfTrainers(int noOfTrainers) {
		this.noOfTrainers = noOfTrainers;
	}
	@Override
	public String toString() {
		return "Institue [instituteName=" + instituteName + ", instituteId=" + instituteId + ", fees=" + fees
				+ ", location=" + location + ", noOfTrainers=" + noOfTrainers + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
