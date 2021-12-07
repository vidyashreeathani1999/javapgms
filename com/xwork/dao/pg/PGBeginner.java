package com.xwork.dao.pg;

public class PGBeginner {

	public static void main(String[] args) {
		
		String pgName="Khushi PG";
		pgName=pgName.replace("","");
		System.out.println(pgName);
		
		PGDAO dao=new PGDAO();
		dao.save("Khushi PG");
		dao.save("Sharada PG");
		dao.save("Amrutha");
		dao.save("Laxmi");
		
		boolean found=dao.find("Sharada PG");
		System.out.println(found);
		
		found=dao.findByCaseInsensitive("sharada pg");
		System.out.println(found);
		
		found=dao.findByCaseInsensitiveAndTrimmed("khushipg");
		System.out.println(found);
		
	}
}
