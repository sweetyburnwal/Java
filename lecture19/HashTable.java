package lecture19;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.NavigableSet;

/**
 * Created by piyush0 on 13/07/17.
 */
public class HashTable<K, V> {
    private class HTPair {
        K key;
        V value;

        public HTPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            HTPair o = (HTPair) obj;
            return this.key.equals(o.key);
        }

        public String toString() {
            return this.key + " : " + this.value;
        }
    }

    private int size;
    private LinkedList<HTPair>[] bucketArray;
    public static final int DEFAULT_CAPACITY = 5;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        this.size = 0;
        this.bucketArray = new LinkedList[capacity];
    }

    private int hashFunction(K key) {
        int hc = key.hashCode();

        hc = Math.abs(hc);
        hc = hc % this.bucketArray.length;

        return hc;
    }

    public void display() {
        for (int i = 0; i < this.bucketArray.length; i++) {
            if (this.bucketArray[i] == null) {
                System.out.println("NULL");
            } else {
                LinkedList<HTPair> bucket = this.bucketArray[i];
                System.out.println(bucket);
            }
        }
    }

    public void put(K key, V value) {
        int bi = this.hashFunction(key);
        HTPair pta = new HTPair(key, value);

        if (this.bucketArray[bi] == null) {
            this.bucketArray[bi] = new LinkedList<>();
            this.bucketArray[bi].addLast(pta);
            this.size++;
        } else {

            LinkedList<HTPair> bucket = this.bucketArray[bi];
            int fi = bucket.indexOf(pta);

            if (fi == -1) {
                bucket.addLast(pta);
                this.size++;
            } else {
                bucket.set(fi, pta);
            }

        }


        double lambda = this.size * 1.0 / this.bucketArray.length;

        if (lambda > 2.0) {
            this.rehash();
        }

    }

    private void rehash() {

        LinkedList<HTPair>[] oba = this.bucketArray;

        this.bucketArray = new LinkedList[2 * oba.length];
        this.size = 0;

        for (int i = 0; i < oba.length; i++) {
            if (oba[i] != null) {

                LinkedList<HTPair> ob = oba[i];
                while (!ob.isEmpty()) {
                    HTPair ptrh = ob.removeFirst();
                    this.put(ptrh.key, ptrh.value);
                }

            }
        }

    }

    public V get(K key) {
        int bi = this.hashFunction(key);

        if (this.bucketArray[bi] == null) {
            return null;
        } else {
            LinkedList<HTPair> bucket = this.bucketArray[bi];
            HTPair pts = new HTPair(key, null);

            int fi = bucket.indexOf(pts);

            if (fi == -1) {
                return null;
            } else {
                return bucket.get(fi).value;

            }
        }
    }

    public V remove(K key) {
        int bi = this.hashFunction(key);

        if (this.bucketArray[bi] == null) {
            return null;
        } else {
            LinkedList<HTPair> bucket = this.bucketArray[bi];
            HTPair pts = new HTPair(key, null);

            int fi = bucket.indexOf(pts);

            if (fi == -1) {
                return null;
            } else {
                this.size--;
                return bucket.remove(fi).value;

            }
        }
    }


}
