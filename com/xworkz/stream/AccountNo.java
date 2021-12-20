package com.xworkz.stream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountNo {
public static void main(String[] args) {
	Stream<Long> accountNoStream=Stream.of(0000012345L,0003214447L,1232462789L,1876324518L,1817265358L,1299825445L,1344559876L,
			456789854L,1234586523L,1456782354L,123324444L,1354234557L,146667324L,1233466665L,766666665L
			,1567987344L,1232445788L,1987634252L,2115611235L,2121114541L);
	
	Set<Long> accountNo=accountNoStream.filter((p)->p<2000000000).collect(Collectors.toSet());
	accountNo.forEach((a)->System.out.println(a));
}
}
