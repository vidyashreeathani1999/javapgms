class ProjectDTO{

public ProjectDTO(){
System.out.println("Project object is created");
}


private String projectName;
private int teamMembers;
private int projectId;


public String getProjectName(){
return projectName;
}

public void setProjectName(String projectName){
this.projectName=projectName;
}

public int getTeamMembers(){
return teamMembers;
}

public void setTeamMembers(int teamMembers){
this.teamMembers=teamMembers;
}

public int getProjectId(){
return projectId;
}

public void setProjectId(int projectId){
this.projectId=projectId;
}

public String toString(){
return "ProjectDTO-{projectName="+this.projectName+",teamMembers="+this.teamMembers+",projectId="+this.projectId+"}";
}
}