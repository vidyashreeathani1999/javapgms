class CivilServiceDTO{

public CivilServiceDTO(){
System.out.println("CivilService object is created");
}

private String examName;
private String examDate;

public String getExamName(){
return examName;
}

public void setExamName(String examName){
this.examName=examName;
}

public String getExamDate(){
return examDate;
}

public void setExamDate(String examDate){
this.examDate=examDate;
}

@Override
public String toString(){
return "CivilServiceDTO-{examName="+this.examName+",examDate="+this.examDate+"}";
}
}