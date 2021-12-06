package com.xwork.clone.pens;

public class PenDTO implements Cloneable{

	private String penName;
	private int penId;
	private int price;
	private String thickness;
	private String color;
	
	
	public String getPenName() {
		return penName;
	}
	public void setPenName(String penName) {
		this.penName = penName;
	}
	public int getPenId() {
		return penId;
	}
	public void setPenId(int penId) {
		this.penId = penId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "PenDTO [penName=" + penName + ", penId=" + penId + ", price=" + price + ", thickness=" + thickness
				+ ", color=" + color + "]";
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

