package lecture11;

/**
 * Created by piyush0 on 27/06/17.
 */
public class Student {

    private String name;

    public void setName(String name) throws Exception {
        if (name == null || name.length() == 0) {
            throw new Exception("The name cannot be set to null or empty");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public final int rollNo;

    private static int numStudents;

    public static final int MAX_LIMIT = 100;

    public void changeRollNo() {
        /// /rollNo = 100; // cannot change value
    }

    public void printName() {
        System.out.println(this.name);
    }

    public Student(String name) throws Exception {

        if (Student.numStudents == Student.MAX_LIMIT) {
            throw new Exception("Max limit reached");
        }

        System.out.println("Hello");
        this.setName(name);
        Student.numStudents++;
        this.rollNo = Student.numStudents;
    }

    public static int getNumStudents() {
//        System.out.println(Student.numStudents);
//        System.out.println(this.name);

        return Student.numStudents;
    }

    public void sayHi() {
        System.out.println(this.name + " says hi to " + Student.numStudents);
    }


}
