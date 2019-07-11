package lecture11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by piyush0 on 27/06/17.
 */
public class StudentClient {
//    public static void main(String[] args) {
//        System.out.println("hi");
//
//        try {
//
//            Student s = new Student();
//            System.out.println("Line 1");
//            s.setName("");
//            System.out.println("Line 2");
//            System.out.println(s.getName());
//        }
//        catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//
//
//        System.out.println("bye");
//    }

    public static void main(String[] args) throws Exception {
        Student[] students = new Student[100];

        try {
            for (int i = 0; i < students.length; i++) {
                System.out.println("Creating " + i + "th student");
                students[i] = new Student(i + "th student");
                System.out.println("Created " + i + "th student");
            }

            System.out.println(students[50].rollNo);
//            System.out.println(students[50].getNumStudents());
            System.out.println(Student.getNumStudents());



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }



    }

    public static void createAnotherStudent() throws Exception {
        System.out.println("Inside function");
        Student s = new Student("Xyz");
    }
}
