package com.xwork.clone.bottle;

public class BottleDTO implements Cloneable{

	private String bottleName;
	private int bottleId;
	private int price;
	private String capacity;
	private String color;
	
	public String getBottleName() {
		return bottleName;
	}
	public void setBottleName(String bottleName) {
		this.bottleName = bottleName;
	}
	public int getBottleId() {
		return bottleId;
	}
	public void setBottleId(int bottleId) {
		this.bottleId = bottleId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String storage) {
		this.capacity = capacity;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Bottle [bottleName=" + bottleName + ", bottleId=" + bottleId + ", price=" + price + ", capacity="
				+ capacity + ", color=" + color + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
