class LibraryDTO{
 int libraryId;
 String typeOfLibrary;
 String libraryName;

public void getDetailsOfLibrary(){
System.out.println(getLibraryId()+" "+getTypeOfLibrary()+" "+getLibraryName());
}


public int getLibraryId(){
return libraryId;
}

public void setLibraryId(int libraryId){
this.libraryId=libraryId;
}

public String getTypeOfLibrary(){
return typeOfLibrary;
}

public void setTypeOfLibrary(String typeOfLibrary){
this.typeOfLibrary=typeOfLibrary;
}

public String getLibraryName(){
return libraryName;
}

public void setLibraryName(String libraryName){
this.libraryName=libraryName;
}

@Override
public String toString(){
return "LibraryDTO-{libraryId="+this.libraryId+",typeOfLibrary="+this.typeOfLibrary+",libraryName="+this.libraryName+"}";
}
}
