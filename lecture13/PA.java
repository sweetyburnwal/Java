package lecture13;

/**
 * Created by piyush0 on 01/07/17.
 */
public abstract class PA {

    // no objects for abstract class
    // it is possible that abstract has no function
    // it is mandatory that class is abstract if there is at least one abstract function

    public void fun(){
        System.out.println("PA's fun");
    }

    public abstract void funA();

}
