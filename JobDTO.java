class JobsDTO{

public JobsDTO(){
System.out.println("Job object is created");
}

private int jobId;
private String jobName;
private String jobType;

public int getJobId(){
return jobId;
}
public void setJobId(int jobId){
this.jobId=jobId;
}

public String getJobName(){
return jobName;
}

public void setJobName(String jobName){
this.jobName=jobName;
}

public String getJobType(){
return jobType;
}

public void setJobType(String jobType){
this.jobType=jobType;
}

@Override
public String toString(){
return "JobDTO-{jobId="+this.jobId+",jobType="+this.jobType+",jobName="+this.jobName+"}";
}
}