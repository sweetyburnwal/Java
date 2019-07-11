package lecture11;

/**
 * Created by piyush0 on 27/06/17.
 */
public class Person {
    int age;
    String name;

    public void sayHi() {
        System.out.println("hi " + this.name);
    }


//    public Person(int param) {
//        System.out.println(param);
//    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(){

    }

}
