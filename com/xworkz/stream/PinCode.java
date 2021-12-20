package com.xworkz.stream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PinCode {
public static void main(String[] args) {
	Stream<Integer> pinCodeStream=Stream.of(560063,560030,560034,587101,587102,587103,587313,587301,587201,530068,
			586101,591218,577201,590001,590002,580009,580021,580023,580001,560010);
	
	Set<Integer> tempPin=pinCodeStream.filter((p)->p>580000).collect(Collectors.toSet());
	tempPin.forEach((p)->System.out.println(p));
	
}
}
