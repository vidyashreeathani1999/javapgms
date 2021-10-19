class JobTester{

public static void main(String args[]){

JobsDTO job=new JobsDTO();
job.setJobId(867);
job.setJobType("IT");
job.setJobName("Software Engineer");

System.out.prinln(job);

JobsDTO job1=new JobsDTO();
job1.setJobId(767);
job1.setJobType("Government");
job1.setJobName("Police");

System.out.prinln(job1);
}
}
