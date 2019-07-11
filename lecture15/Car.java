package lecture15;

/**
 * Created by piyush0 on 06/07/17.
 */
public class Car implements Comparable<Car> {
    private String name;
    protected int speed;
    public int price;
    char something;

    public Car(String name, int speed, int price) {
        this.name = name;
        this.speed = speed;
        this.price = price;
    }

    public String toString() {
        return "[" + this.name + " : " + this.price + ", " + this.speed + "]\n";
    }

    @Override
    public int compareTo(Car o) {
        return this.name.compareTo(o.name);
    }
}
