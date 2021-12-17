package com.xworkz.map1.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Movies {
public static void main(String[] args) {
	Map<String,Float> movieOfRatingMap=new TreeMap<String, Float>((e1,e2)->e2.compareTo(e1));
	
	movieOfRatingMap.put("Ugramm", 8.1f);
	movieOfRatingMap.put("Gultoo", 8.2f);
	movieOfRatingMap.put("Rangitaranga", 8.2f);
	movieOfRatingMap.put("Jatta", 8.2f);
	movieOfRatingMap.put("Kirik Party", 8.3f);
	movieOfRatingMap.put("Ram Ram Re", 8.3f);
	movieOfRatingMap.put("Sa.Hi.Pra.Shaale, Kasaragodu", 8.7f);
	movieOfRatingMap.put("Upendra", 8.8f);
	movieOfRatingMap.put("GBSM", 8.7f);
	movieOfRatingMap.put("A", 8.7f);
	
	System.out.println("List of Movies");
	Set<String> keys=movieOfRatingMap.keySet();
	keys.forEach((e)->System.out.println(e));
	
	System.out.println("====================");
	System.out.println("List of Ratings");
	Collection<Float> values=movieOfRatingMap.values();
	values.forEach((a)->System.out.println(a) );
	
	System.out.println("====================");
	System.out.println("List of Movies and Ratings");
	Set<Map.Entry<String, Float>> entrySet=movieOfRatingMap.entrySet();
	entrySet.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
	
	System.out.println("=================");
	System.out.println("List of Movies and Ratings in Decending Order");
	Iterator<Map.Entry<String,Float>> itr=entrySet.iterator();
	while(itr.hasNext()) {
		Map.Entry<String, Float> entry=itr.next();
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	}
	
}
}
