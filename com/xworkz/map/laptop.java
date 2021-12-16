package com.xworkz.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class laptop {

	public static void main(String[] args) {
		
       Map map=new HashMap();
		
		map.put("Acer Aspire", "5 gen Intel");
		map.put("Dell Inspiron 15", "11 gen Intel");
		map.put("Dell Inspiron 14", "11 gen Intel");
		map.put("11 gen Intel","Lenovo");
		
		System.out.println(map.size());
	
	     
		System.out.println(map.get("Acer Aspire"));
		
		boolean contains=map.containsKey("HP");
		System.out.println(contains);
		
		contains=map.containsValue("11 gen Intel");
		System.out.println(contains);
		
		System.out.println(map);
		Set<String> keys=map.keySet();
		keys.forEach((a)->{
			System.out.println(a);
		});
		
		
	}
}
