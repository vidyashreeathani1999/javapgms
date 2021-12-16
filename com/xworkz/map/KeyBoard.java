package com.xworkz.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeyBoard {

public static void main(String[] args) {
	Map map=new HashMap();
	map.put("Alphabets", 26);
	map.put("Number", 10);
	map.put("Function Keys", 12);
	
	System.out.println(map.size());
	
	System.out.println(map.get("Number"));
	
	boolean contains=map.containsKey("Function Keys");
	System.out.println(contains);
	
	contains=map.containsValue(26);
	System.out.println(contains);
	
	Set<String> keys=map.keySet();
	keys.forEach((a)->{
		System.out.println(a);
	});
}
}
