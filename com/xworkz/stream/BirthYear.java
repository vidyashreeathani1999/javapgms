package com.xworkz.stream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BirthYear {

	public static void main(String[] args) {
		Stream<Integer> birthYearStream=Stream.of(1996,1998,1999,2000,2003,1999,2017,2015,2008,1997,
				1994,1992,2005,2002,2001,1999,2009,2012,2000,1999);
		
		Set<Integer> tempPin=birthYearStream.filter((p)->p>1999).sorted().collect(Collectors.toSet());
		tempPin.forEach((p)->System.out.println(p));
	}
}
