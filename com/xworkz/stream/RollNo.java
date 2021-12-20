package com.xworkz.stream;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RollNo {

	public static void main(String[] args) {
		
		
		Stream<Integer> rollNoStream=Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		List<Integer> tempRoll=rollNoStream.filter((p)->p<20).sorted(Collections.reverseOrder()).collect(Collectors.toList());
		tempRoll.forEach((r)->System.out.println(r));
		
		
		
		}
		
	}

