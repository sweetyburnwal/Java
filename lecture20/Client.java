package lecture20;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by piyush0 on 15/07/17.
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>
                (Arrays.asList(20, 50, 10, 70, 30, 40, 60));
        heapSort(arr);
        System.out.println(arr);
    }

    public static void heapSort(ArrayList<Integer> arr) {

        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            downHeapify(i, arr, arr.size());
        }


        for (int i = 0; i < arr.size(); i++) {

            Integer temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1 - i));
            arr.set(arr.size() - 1 - i, temp);

            downHeapify(0, arr, arr.size() - 1 - i);

        }

    }

    public static void downHeapify(int pi, ArrayList<Integer> data, int lastPosition) {

        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        int mi = pi;

        if (lci < lastPosition && data.get(lci) > data.get(mi)) {
            mi = lci;
        }

        if (rci < lastPosition && data.get(rci) > data.get(mi)) {
            mi = rci;
        }

        if (mi != pi) {
            Integer temp = data.get(mi);
            data.set(mi, data.get(pi));
            data.set(pi, temp);

            downHeapify(mi, data, lastPosition);
        }
    }


}
