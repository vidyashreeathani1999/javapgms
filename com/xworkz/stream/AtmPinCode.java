package com.xworkz.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtmPinCode {
public static void main(String[] args) {
	Stream<Integer> atmPinCodeStream=Stream.of(0077,0213,9752,0123,1234,2345,0734,2456,
			0345,9742,6536,2986,0006,9724,0210,3258,9421,7342,1726,4176);
	
	List<Integer> tempAtm=atmPinCodeStream.filter((a)->a>1000).sorted().collect(Collectors.toList());
	tempAtm.forEach((t)->System.out.println(t));
	
}
}
