package lecture25;

import lecture20.Heap;

import java.util.*;

/**
 * Created by piyush0 on 28/07/17.
 */
public class AsgnHT_Heaps {
    public static void main(String[] args) {
        int[] arr = {15, 13, 23, 21, 19, 11, 16};
        System.out.println(kThSmallest(arr, 3));
    }

    public static void lcs(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int currValue = arr[i];
            int nextValue = currValue + 1;
            int prevValue = currValue - 1;

            if (map.containsKey(prevValue)) {
                map.put(currValue, false);
            } else {
                map.put(currValue, true);
            }

            if (map.containsKey(nextValue)) {
                map.put(nextValue, false);
            }

        }

        int start = 0;
        int maxSize = 0;

        Set<Integer> keys = map.keySet();

        for (Integer key : keys) {

            if (map.get(key)) {
                int currSize = 1;
                int currStart = key;

                while (true) {
                    if (!map.containsKey(currStart + currSize)) {
                        break;
                    }
                    currSize++;
                }

                if (currSize > maxSize) {
                    maxSize = currSize;
                    start = currStart;
                }


            }

        }

        for (int i = 0; i < maxSize; i++) {
            System.out.println(start + i);
        }
    }

    public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();


        PriorityQueue<Triplet> minHeap = new PriorityQueue<>();
        int k = lists.size();

        for (int i = 0; i < k; i++) {
            Integer listNo = i;
            Integer idx = 0;
            Integer value = lists.get(listNo).get(idx);

            Triplet triplet = new Triplet(value, listNo, idx);
            minHeap.add(triplet);
        }

        while (!minHeap.isEmpty()) {

            Triplet justRemoved = minHeap.poll();

            rv.add(justRemoved.value);

            Integer listNo = justRemoved.listNo;
            Integer idx = justRemoved.idx + 1;

            if (idx < lists.get(listNo).size()) {
                Integer value = lists.get(listNo).get(idx);

                Triplet toBeAdded = new Triplet(value, listNo, idx);
                minHeap.add(toBeAdded);
            }

        }

        return rv;
    }

    private static class Triplet implements Comparable<Triplet> {
        Integer value;
        Integer listNo;
        Integer idx;

        public Triplet(Integer value, Integer listNo, Integer idx) {
            this.value = value;
            this.listNo = listNo;
            this.idx = idx;
        }

        @Override
        public int compareTo(Triplet o) {
            return this.value - o.value;
        }
    }

    public static int kThSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }


        for (int i = k + 1; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        return maxHeap.peek();
    }
}
