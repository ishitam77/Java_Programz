/*Develop and test a Java class named Student with the (private) instance fields namely, registration
number, name, the date of birth and a list of a maximum of three courses a student has registered in. If
a student has registered in less than three courses then use null. Provide constructors for the class
showing how one constructor can call some other constructor and include accessor and mutator
methods for each of the instance fields. Include a method into the class to compute the age of a
student. Create an array of objects of three students after receiving input from the keyboard using
object of BufferedReader class and display for each student her/his registration number, name and age
in a tabular format with column header. */

import java.io.*;
import java.time.*;
public class Student extends Object {
    
     private String Reg_no,name,Dob,Course1,Course2,Course3;
     private int age;

    public Student(String Reg_no, String name,String Dob,String Course1,String Course2,String Course3,int age) {
        this.Reg_no = Reg_no;
        this.name = name;
        this.Dob=Dob;
        this.Course1 = Course1;
        this.Course2 = Course2;
        this.Course3 = Course3;
        this.age=age;
    }
    public Student(String Reg_no, String name, String Dob) {
    this(Reg_no, name, Dob, null,null,null,0);
    }

    public String getReg_no() {
        return Reg_no;
    }
    public String getname() {
        return name;
    }
    public String Dob() {
        return Dob;
    }
    public String getCourse1() {
        return Course1;
    }
    public String getCourse2() {
        return Course2;
    }
    public String getCourse3() {
        return Course3;
    }
    public int getage() {
        return age;
    }


    public void setReg_no(String Reg_no) {
        this.Reg_no = Reg_no;
    }
    public void setname(String name) {
        this.name = name;
    }
    public void setDob(String Dob) {
        this.Dob = Dob;
    }
    public void setCourse1(String Course1) {
        this.Course1 = Course1;
    }
    public void setCourse2(String Course2) {
        this.Course2 = Course2;
    }
    public void setCourse3(String Course3) {
        this.Course3 = Course3;
    }
    public void setCourse3(int age) {
        this.age= age;
    }

public static String checkNullEmptyBlank(String strToCheck) {    
        if (strToCheck.isEmpty()) 
            return "Null"; 
            else
            return strToCheck; 
            }  

public static void main(String args[])throws Exception{ 
    Student[] stu=new Student[3];
    for(int i=0;i<stu.length;i++){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter Reg_no: ");
        String Reg_no  = br.readLine();
        System.out.print("Enter Name: ");
        String name  = br.readLine();
        System.out.print("Enter Dob (yyyy-mm-dd): ");
        String Dob  = br.readLine();
        System.out.print("Enter Course1: ");
        String Course1  = br.readLine();
        System.out.print("Enter Course2: ");
        String Course2  = br.readLine();
        System.out.print("Enter Course3: ");
        String Course3  = br.readLine();
        LocalDate DOB = LocalDate.parse(Dob);
        LocalDate currentDate;
        currentDate = LocalDate.now();
        int age = Period.between(DOB, currentDate).getYears();
        stu[i]=new Student(Reg_no,name,Dob,Course1,Course2,Course3,age);
    }

    System.out.println("Reg_no \t\t Name \t\t\t Dob \t\t Course1 \t Course2 \t Course3 \t Age \t");
    System.out.println("----------------------------------------------------------------------------------------------------------");
    for(int i=0;i<stu.length;i++){
        System.out.print(stu[i].Reg_no);
        System.out.print("\t" + stu[i].name);
        System.out.print("\t\t" + stu[i].Dob);
        System.out.print("\t\t" + checkNullEmptyBlank(stu[i].Course1));
        System.out.print("\t\t " + checkNullEmptyBlank(stu[i].Course2));
        System.out.print("\t\t" + checkNullEmptyBlank(stu[i].Course3));
        System.out.print("\t\t" + stu[i].age);
        System.out.println();
    }
}    
}
