package com.xworkz.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Aadhar {

public static void main(String[] args) {
	
	Map map=new HashMap();
	
	map.put("Vidyashree", "5432 2112 8987");
	map.put("Aishwarya", "4213 3256 2352");
	map.put("santosh", "5672 8786 0987");
	map.put("Deepa","0198 1823 8277");
	
	System.out.println(map.size());

     
	System.out.println(map.get("Deepa"));
	
	boolean contains=map.containsKey("Tarun");
	System.out.println(contains);
	
	contains=map.containsValue("5672 8786 0987");
	System.out.println(contains);
	
	System.out.println(map);
	Set<String> keys=map.keySet();
	keys.forEach((a)->{
		System.out.println(a);
	});
}
}
