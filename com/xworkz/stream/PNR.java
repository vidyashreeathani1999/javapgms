package com.xworkz.stream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PNR {
public static void main(String[] args) {
	Stream<Long> pnrStream=Stream.of(2001231396L,1035531998L,1943865199L,2083263001L,2002732103L,1912092799L,2023478917L,2032464715L,9765352008L,8771996311l,
			1914449614L,1345521992L,202452205L,2345087902L,2679724001L,1899531299L,20122921809L,2018654512L,2032109730L,1313341999L);
	
	Set<Long> tempPnr=pnrStream.filter((p)->p>1912092799L).collect(Collectors.toSet());
	tempPnr.forEach((p)->System.out.println(p));
}
}
