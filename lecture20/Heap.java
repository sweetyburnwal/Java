package lecture20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

/**
 * Created by piyush0 on 15/07/17.
 */
public class Heap<T extends Comparable<T>> {

    private ArrayList<T> data;
    private boolean isMin;

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public Heap(T[] arr, boolean isMin) {
        this(isMin);

        for (int i = 0; i < arr.length; i++) {
            this.data.add(arr[i]);
        }


        for (int i = this.size() / 2 - 1; i >= 0; i--) {
            this.downHeapify(i);
        }

    }

    public Heap(boolean isMin) {
        this.data = new ArrayList<>();
        this.isMin = isMin;
    }

    public Heap() {
        this(false);
    }

    public T get() {
        return this.data.get(0);
    }

    private void swap(int i, int j) {
        T temp = this.data.get(i);
        this.data.set(i, this.data.get(j));
        this.data.set(j, temp);
    }

    public void add(T item) {
        this.data.add(item);
        this.upHeapify(this.data.size() - 1);
    }

    private void upHeapify(int ci) {
        if (ci == 0) {
            return;
        }

        int pi = (ci - 1) / 2;

        if (isIlarger(ci, pi)) {
            this.swap(ci, pi);
            this.upHeapify(pi);
        }

    }

    private boolean isIlarger(int i, int j) {

        T iIthItem = this.data.get(i);
        T jThItem = this.data.get(j);

        if (this.isMin) {
            return iIthItem.compareTo(jThItem) < 0;
        } else {
            return iIthItem.compareTo(jThItem) > 0;
        }
    }

    public void display() {
        this.display(0);
    }

    private void display(int idx) {
        if (idx >= this.data.size()) {
            return;
        }

        int lci = 2 * idx + 1;
        int rci = 2 * idx + 2;

        if (lci < this.data.size()) {
            System.out.print(this.data.get(lci) + " => ");
        } else {
            System.out.print("END => ");
        }

        System.out.print(this.data.get(idx));

        if (rci < this.data.size()) {
            System.out.print(" <= " + this.data.get(rci));
        } else {
            System.out.print(" <= END");
        }

        System.out.println();

        this.display(lci);
        this.display(rci);
    }

    public T remove() {
        T rv = this.data.get(0);

        this.swap(0, this.data.size() - 1);
        this.data.remove(this.data.size() - 1);
        this.downHeapify(0);

        return rv;

    }

    private void downHeapify(int pi) {

        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        int mi = pi;

        if (lci < this.data.size() && this.isIlarger(lci, mi)) {
            mi = lci;
        }

        if (rci < this.data.size() && this.isIlarger(rci, mi)) {
            mi = rci;
        }

        if (mi != pi) {
            this.swap(mi, pi);
            this.downHeapify(mi);
        }

    }
}
