package com.xworkz.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContinetInvoke {

	public static void main(String[] args) {
	
		Map map=new HashMap();
		map.put("Asia", "India");
		map.put("Africa", "Kenya");
		map.put("North America", "US");
		map.put("Asia", "Thailand");
		
		System.out.println(map.size());
		
		System.out.println(map.get("Asia"));
		
		boolean contains=map.containsKey("North America");
		System.out.println(contains);
      
		contains=map.containsValue("Kenya");
		System.out.println(contains);
		
		Set <String> keys=map.keySet();
		keys.forEach((e)->{System.out.println(e);});
		
		//System.out.println(map.isEmpty());
		//System.out.println(map.remove("Asia","Thailand"));
	}
}

