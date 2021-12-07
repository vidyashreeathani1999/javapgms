package com.xwork.dao.ipl;

import com.xwork.dao.pg.PGDAO;

public class IPLInvoke {
public static void main(String[] args) {
	String teamName="RCB";
	teamName=teamName.replace("","");
	System.out.println(teamName);
	
	IPLDAO dao=new IPLDAO();
	dao.save("RCB");
	dao.save("DC");
	dao.save("KKR");
	
	boolean found=dao.find("rcb");
	System.out.println(found);
	
	found=dao.findByCaseInsensitive("dc");
	System.out.println(found);
	
	found=dao.findByCaseInsensitiveAndTrimmed("kkr");
	System.out.println(found);
	
}
}
