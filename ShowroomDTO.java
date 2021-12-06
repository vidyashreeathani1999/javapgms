package com.xwork.clone.showrooms;

public class ShowroomDTO implements Cloneable{

	private String showroomName;
	private int showroomId;
	private long contactNo;
	private String location;
	private String ownerName;
	
	
	public String getShowroomName() {
		return showroomName;
	}
	public void setShowroomName(String showroomName) {
		this.showroomName = showroomName;
	}
	public int getShowroomId() {
		return showroomId;
	}
	public void setShowroomId(int showroomId) {
		this.showroomId = showroomId;
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
		return "ShowroomDTO [showroomName=" + showroomName + ", showroomId=" + showroomId + ", contactNo=" + contactNo
				+ ", location=" + location + ", ownerName=" + ownerName + "]";
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
