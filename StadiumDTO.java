package com.xwork.clone.stadium;

public class StadiumDTO implements Cloneable{

	private String stadiumName;
	private int stadiumId;
	private int ticket;
	private String location;
	private int noOfSeats;
	
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public int getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	@Override
	public String toString() {
		return "StadiumDTO [stadiumName=" + stadiumName + ", stadiumId=" + stadiumId + ", ticket=" + ticket
				+ ", location=" + location + ", noOfSeats=" + noOfSeats + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
