package com.xwork.clone.travel;

public class TravelDTO implements Cloneable{

	private String TravelName;
	private int busId;
	private long contactNo;
	private String location;
	private int noOfPassenger;
	private int cost;
	public String getTravelName() {
		return TravelName;
	}
	public void setTravelName(String travelName) {
		TravelName = travelName;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "TravelDTO [TravelName=" + TravelName + ", busId=" + busId + ", contactNo=" + contactNo + ", location="
				+ location + ", noOfPassenger=" + noOfPassenger + ", cost=" + cost + "]";
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
