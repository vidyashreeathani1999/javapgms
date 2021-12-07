package com.xwork.dao.gym;

import com.xwork.dao.pg.PGDAO;

public class GYMBeginner {
public static void main(String[] args) {
	
	String gymName="Quadz Fitness";
	gymName=gymName.replace("","");
	System.out.println(gymName);
	
	GYMDAO dao=new GYMDAO();
	dao.save("Quadz Fitness");
	dao.save("JJ Gym");
	dao.save("Moveza Fitness");
	
	boolean found=dao.find("Mind and Body Fitness");
	System.out.println(found);
	
	found=dao.findByCaseInsensitive("jj gym");
	System.out.println(found);
	
	found=dao.findByCaseInsensitiveAndTrimmed("movezafitness");
	System.out.println(found);
	
}
}
