package com.xwork.clone.laptop;

public class LaptopTester {

	public static void main(String[] args) throws CloneNotSupportedException {
		LaptopDTO laptopDTO=new LaptopDTO();
		laptopDTO.setLaptopId(1);
		laptopDTO.setLaptopName("Lenovo");
		laptopDTO.setPrice(40000);
		laptopDTO.setColor("Black");
		laptopDTO.setStorage("1TB");
		
		LaptopDTO lap=(LaptopDTO)laptopDTO.clone();
		System.out.println(lap);
		}
}
