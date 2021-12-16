package com.xworkz.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountryInvoke {

	public static void main(String[] args) {
		
		Map map=new HashMap();
		
		map.put("India", 91);
		map.put("Afghanistan", 93);
		map.put("Albania",355);
		map.put("Colombia",57);
		
		System.out.println(map.size());
	 
		System.out.println(map.get("India"));
		
		boolean contains=map.containsKey("USA");
		System.out.println(contains);
		
		contains=map.containsValue(93);
		System.out.println(contains);
		
		Set <String> keys=map.keySet();
		
		keys.forEach((a)->{ System.out.println(a);});
	
	}
}
