/**
author : vidchayada abhicharttibutra
student ID : 672115044
*/
import java.io.*;
import java.util.*;
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
  public char getLastname(){return lastName.charAt(0);}

  public String toString(){
  return this.SID + " " + this.firstName + " " + this.lastName;
  }
}
public class Student{
  public static void main(String[] args) throws FileNotFoundException{
      File f = new File("C:\\Users\\vidch\\OneDrive\\Desktop\\เนยขมปี๋\\ADT\\class_roaster67.csv");
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
      Scanner sc = new Scanner(System.in);
      String choice = sc.nextLine();
      if(choice.equals("-n")){
        SortStudentid(student);
      }else if(choice.equals("-f")){
        Sortfirstname(student);
      }else if(choice.equals("-l")){
        Sortlastname(student);
      }else if(choice.equals("-s")){
        String name = sc.nextLine();
        Sortindex(student, name);
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
    for (char lastLetter = 'A';lastLetter<='Z';lastLetter++){
      for(int i=0; i<student.size(); i++){
          if(student.get(i).getLastname()==lastLetter){
              System.out.println(student.get(i));
          }
      }
    }
    }
  public static void Sortindex(Vector<Studentvalue> student,String name){
    String Name = name.toUpperCase();
    for (int j = 0; j < student.size(); j++) {
      String fname = student.get(j).getFirstname().toUpperCase().trim();
        if (fname.equals(Name)) {
            System.out.println("found at index : " + j);
            break;
        }
    }
}
}

