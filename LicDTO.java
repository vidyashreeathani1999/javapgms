class LicDTO{


 int licId;
 String agentName;
 String customerName;
 String year;

public void getLicDetails(){
System.out.println(getLicId()+" "+getAgentName()+" "+getCustomerName()+" "+getYear());
}


public int getLicId(){
return licId;
}

public void setLicId(int licId){
this.licId=licId;
}

public String getAgentName(){
return agentName;
}

public void setAgentName(String agentName){
this.agentName=agentName;
}

public String getCustomerName(){
return customerName;
}

public void setCustomerName(String customerName){
this.customerName=customerName;
}

public String getYear(){
return year;
}

public void setYear(String year){
this.year=year;
}

@Override
public String toString(){
return "LicDTO-{licId="+this.licId+",agentName="+this.agentName+",customerName="+this.customerName+",year="+this.year+"}";
}
}
