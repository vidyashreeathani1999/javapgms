package com.xworkz.malls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Malls {

	public static void main(String[] args) {
		Collection collection=new ArrayList<>();
		
		 String[] mall={"Mantri mall", "Orian mall", "Garuda"};
		
		 
		// Sorting the array in ascending order
		 Arrays.sort(mall);
		 System.out.println(Arrays.toString(mall));
			 
			
        // Sorting the array in descending order
        Arrays.sort(mall, Collections.reverseOrder());
        System.out.println(Arrays.toString(mall));
    }
}