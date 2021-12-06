package com.xwork.clone.canteen;

public class CanteenDTO implements Cloneable{

	private String canteenName;
	private int canteenId;
	private long contactNo;
	private String location;
	private String ownerName;
	
	
	public String getCanteenName() {
		return canteenName;
	}
	public void setCanteenName(String canteenName) {
		this.canteenName = canteenName;
	}
	public int getCanteenId() {
		return canteenId;
	}
	public void setCanteenId(int canteenId) {
		this.canteenId = canteenId;
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
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
	@Override
	public String toString() {
		return "CanteenDTO [canteenName=" + canteenName + ", canteenId=" + canteenId + ", contactNo=" + contactNo
				+ ", location=" + location + ", ownerName=" + ownerName + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
