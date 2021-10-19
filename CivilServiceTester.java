class CivilServiceTester{

public static void main(String args[]){
CivilServiceDTO cv=new CivilServiceDTO();
cv.setExamName("IAS");
cv.setExamDate("15/5/2021");
System.out.println(cv);

CivilServiceDTO cv1=new CivilServiceDTO();
cv1.setExamName("IpS");
cv1.setExamDate("19/8/2021");
System.out.println(cv1);

CivilServiceDTO cv2=new CivilServiceDTO();
cv2.setExamName("IFS");
cv2.setExamDate("21/2/2021");
System.out.println(cv2);

}
}