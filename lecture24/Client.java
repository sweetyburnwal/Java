package lecture24;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by piyush0 on 23/07/17.
 */
public class Client {
    public static void main(String[] args) {
//        TTT ttt = new TTT();


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hi");
            }
        }, 0, 1000);
    }
}
