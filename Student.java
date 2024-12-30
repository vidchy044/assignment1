/**
author : vidchayada abhicharttibutra
student ID : 672115044
*/
import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.sql.SQLFeatureNotSupportedException;
class Studentvalue{
    private String SID;
    private String firstName;
    private String lastName;
  
  public Studentvalue(String SID,String firstName,String lastName){
    this.SID = SID;
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public String getSID(){return SID;}
  public String getFirstname(){return firstName;}
  public String getLastname(){return lastName;}

  public String toString(){
  return this.SID + " " + this.firstName + " " + this.lastName;
  }
}
public class Student{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner input = new Scanner(System.in);
      String intp = input.nextLine();

        StringTokenizer ch = new StringTokenizer(intp, " ");
        String choice = ch.nextToken();
        String file = ch.nextToken();

      File f = new File(file);
      Scanner in = new Scanner(f);

      for(int i=0;i<7;i++){
         in.nextLine();
      }

      Vector<Studentvalue> student = new Vector<Studentvalue>();

      while(in.hasNextLine()){
        String dataLine = in.nextLine();
        StringTokenizer stu = new StringTokenizer(dataLine.trim(),",");
        stu.nextToken();
        student.addElement(new Studentvalue(stu.nextToken(),stu.nextToken(),stu.nextToken()));
      }
      
      switch (choice) {
        case "-n":
        SortStudentid(student);
            break;
        case "-f":
        Sortfirstname(student);
            break;
        case "-l":
        Sortlastname(student);
            break;
        case "-s":
        String find = ch.nextToken().toUpperCase().trim();
        Sortindex(student, find);
            break;
        default:
            break;
    }
   }
  
  public static void SortStudentid(Vector<Studentvalue> student){
    student.sort(Comparator.comparing(Studentvalue::getSID));
    for (Studentvalue s : student) {
        System.out.println(s);
    }
    }
  public static void Sortfirstname(Vector<Studentvalue> student){
    student.sort(Comparator.comparing(Studentvalue::getFirstname));
    for (Studentvalue s : student) {
        System.out.println(s);
    }
  }
  public static void Sortlastname(Vector<Studentvalue> student){
    student.sort(Comparator.comparing(Studentvalue::getLastname));
        for (Studentvalue s : student) {
         System.out.println(s);
    }
  }
  public static void Sortindex(Vector<Studentvalue> student,String find){
    for (int j = 0; j < student.size(); j++) {
      String fname = student.get(j).getFirstname().toUpperCase().trim();
        if (fname.equals(find)) {
            System.out.println("found at index : " + j);
            break;
        }
    }
}
}
