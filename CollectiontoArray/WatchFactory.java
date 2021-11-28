package com.xworkz.watchfactory;

import java.util.ArrayList;
import java.util.Collection;

public class WatchFactory {
	
	public static void main(String[] args) {
		
	Collection collection=new ArrayList<>();
	
	collection.add("Titan");
	 collection.add("Timex");
	 collection.add("Casio");
	 collection.add( "Rolex");
	 collection.add("Guess");
	 collection.add( "Fossil");
	 collection.add("Giordano");
	 
 
	 Object[] obj = collection.toArray();
	 for(int i=0; i<obj.length; i++) {
		 
	 }

	System.out.println(collection.size());
	collection.forEach(System.out::println);
	}
	 
}
