package com.xwork.dao.email;



public class EmailInvoke {
	public static void main(String[] args) {
	
		String emailName="vidyashree@gmail.com";
		emailName=emailName.replace("","");
		System.out.println(emailName);
		
	    EmailDAO dao=new EmailDAO();
		dao.save("vidyashree@gmail.com");
		dao.save("vidya.in");
		
		EmailSearch email=new SearchByCom();
		
		boolean found=dao.find(email,"vidyashree@gmail.com");
		System.out.println(found);
		
		EmailSearch email1=new SearchByMail();
		boolean found1=dao.find(email,"vidyashree@gmai");
		System.out.println(found1);
		
		EmailSearch email2=new SearchByIn();
		boolean found2=dao.find(email,"vidya.in");
		System.out.println(found2);
		
}

}
