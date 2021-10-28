package com.xworkz.google;

import com.xworkz.google.dto.GoogleApplicationsDTO;

public class Google {

	
		public GoogleApplicationsDTO[] applications ;
		  private int index;

		public Google(int size){
		 applications=new GoogleApplicationsDTO[size];
		}
		
		public boolean createGoogleApplicationsDetails(GoogleApplicationsDTO applications){
			boolean applicationsAdded=false;
			System.out.println("inside createApplications()");
			if(applications!=null){
			  this.applications[index++]=applications;
			  applicationsAdded=true;
			}

			else{
			System.out.println("No applications added");
			return applicationsAdded=false;
			}
			return applicationsAdded;
			}
		
		public void getAllApplications(){
			for(int i=0;i<applications.length;i++){
			System.out.println(applications[i]);
			}
			}
		
		public GoogleApplicationsDTO getApplicationByName(String applicationName){
			GoogleApplicationsDTO googleApplicationsDTO=null;
			System.out.println("inside getApplicationByName()");
			if(applicationName!=null){
			   for(int i=0;i<applications.length;i++){
			     if(applications[i].getApplicationName().equals(applicationName)){
			System.out.println("Application found by Name:"+applicationName);
			      googleApplicationsDTO=applications[i];
			     }
			  
			else{
			System.out.println("No Application Found by Name:"+applicationName);
			}
			   }
			}
			return googleApplicationsDTO;
			}
	    

	    public GoogleApplicationsDTO getApplicationById(int applicationId){
		GoogleApplicationsDTO googleApplicationsDTO=null;
		System.out.println("inside getApplicationById()");
		if(applicationId!=0){
		   for(int i=0;i<applications.length;i++){
		     if(applications[i].getApplicationId()==(applicationId)){
		System.out.println("Application found by Id:"+applicationId);
		   googleApplicationsDTO=applications[i];
		     }
		  
		else{
		System.out.println("No Application Found by Id:"+applicationId);
		}
		   }
		}
		return googleApplicationsDTO;
	}
	    
	    
	   
	    public void updateApplicationNameByApplicationId(String applicationName,int applicationId){
	    	System.out.println("inside updateApplicationNameByApplicationId()");
	    	if(applicationId>0&&applicationName!=null){
	    	   for(int i=0;i<applications.length;i++){
	    	     if(applications[i].getApplicationId()==(applicationId)){
	    	System.out.println("Application Name updated by:"+applicationName);
	    	   applications[i].setApplicationName(applicationName);
	    	     }

	    	else{
	    	System.out.println("Application not updated");
	    	}
	    	   }
	    	}
	    }


	    public void deleteApplicationById(int applicationId){
	    	System.out.println("Inside deleteApplicationById()");
	    	if(applicationId > 0){
	    	for(int i=0; i<applications.length; i++){
	    	if(applications[i].getApplicationId()==(applicationId)){
	    	System.out.println("Application deleted by id : "+applicationId);
	    	applications[i].setApplicationId(applicationId);
	    	}
	    	
	    	
	    	else{
	    	System.out.println("Application is not deleted");
	    	}
	    	}
	    	}
	    			
	    }
	    }
	    	
	    	





		


