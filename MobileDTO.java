package com.xwork.clone.mobiles;

public class MobileDTO implements Cloneable{

	private String moblileName;
	private int mobileId;
	private int price;
	private String storage;
	private String color;
	public String getMoblileName() {
		return moblileName;
	}
	public void setMoblileName(String moblileName) {
		this.moblileName = moblileName;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return "MobileDTO [moblileName=" + moblileName + ", mobileId=" + mobileId + ", price=" + price + ", storage="
				+ storage + ", color=" + color + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	
}
