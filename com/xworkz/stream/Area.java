package com.xworkz.stream;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Area {
public static void main(String[] args) {
	System.out.println("Area in Asceding order and lowercase");
	Stream<String> areaStream=Stream.of("Rajajinagar","Gaytrinagar","Jayanagar","koramangala","Malleshwaram","Mahalaxmi Layout",
			"Sadashivanagar","HSR Layout","Basavanagudi","Akshayanagar","BCC Layout","Nagarbavi","BTM",
			"Annapurneshwari Nagar","Chamundeshwari Layout");
	List<String> area=areaStream.map(String::toLowerCase).sorted().collect(Collectors.toList());
	area.forEach((a)->System.out.println(a));
	
	
	System.out.println("==================");
	System.out.println("Area in Descending order and uppercase");
	Stream<String> areaStream1=Stream.of("Rajajinagar","Gaytrinagar","Jayanagar","koramangala","Malleshwaram","Mahalaxmi Layout",
			"Sadashivanagar","HSR Layout","Basavanagudi","Akshayanagar","BCC Layout","Nagarbavi","BTM",
			"Annapurneshwari Nagar","Chamundeshwari Layout");	
	List<String> area1=areaStream1.map(String::toUpperCase).sorted(Collections.reverseOrder()).collect(Collectors.toList());
	area1.forEach((a1)->System.out.println(a1));
}
}
