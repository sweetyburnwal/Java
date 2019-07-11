package lecture19;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by piyush0 on 13/07/17.
 */
public class Client {
//    public static void main(String[] args) {
//
//        HashMap<String, Integer> popMap = new HashMap<>();
//
//        popMap.put("India", 120);
//        popMap.put("China", 200);
//        popMap.put("Uk", 40);
//        popMap.put("US", 100);
//
//        System.out.println(popMap);
//
//        popMap.put("India", 200);
//        System.out.println(popMap);
//
//        System.out.println(popMap.get("India"));
//        System.out.println(popMap.get("Pak"));
//
//        System.out.println(popMap.remove("China"));
//        System.out.println(popMap.remove("China"));
//        System.out.println(popMap);
//
//        System.out.println(popMap.containsKey("Uk"));
//        System.out.println(popMap.containsKey("China"));
//
//        /* keys */
//
//        Set<String> keys = popMap.keySet();
//        System.out.println(keys);
//
//        for (String key : keys) {
//            System.out.println(key);
//        }
//
//        /* Values */
//
//        Collection<Integer> values = popMap.values();
//        System.out.println(values);
//
//        for (Integer i : values) {
//            System.out.println(i);
//        }
//
//        /* Entries */
//
//        Set<Map.Entry<String, Integer>> entries = popMap.entrySet();
//
//        System.out.println(entries);
//
//        for (Map.Entry<String, Integer> entry : entries) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//    }

//    public static void main(String[] args) {
////        System.out.println(highestFrequency("aaaabbbkbjaskjascjkb"));
//
////        int[] arr = {1, 5, 1, 3, 3, 2, 5, 5};
////        System.out.println(getUnique(arr));
//
//        int[] one = {1, 1, 1, 2, 3, 2, 4, 5, 5};
//        int[] two = {0, 0, 1, 2, 2, 2, 4, 3, 6};
////        System.out.println(gce1(one, two));
//
//        System.out.println(gce2(one, two));
//    }

    public static void main(String[] args) {
        HashTable<String, Integer> popMap = new HashTable<>(3);

        popMap.put("India" , 120);
        popMap.put("China" , 200);
        popMap.put("US" , 50);
        popMap.put("UK" , 60);
        popMap.put("SA" , 100);
        popMap.put("Spain", 40);
        popMap.put("Germany", 70);

       popMap.display();
    }


    public static Character highestFrequency(String word) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (freqMap.containsKey(ch)) {

                int of = freqMap.get(ch);
                int nf = of + 1;
                freqMap.put(ch, nf);

            } else {
                freqMap.put(ch, 1);
            }
        }

        System.out.println(freqMap);

        Character retVal = '\0';
        Integer maxFreq = 0;

        Set<Map.Entry<Character, Integer>> entries = freqMap.entrySet();

        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                retVal = entry.getKey();
            }
        }

        return retVal;
    }

    public static ArrayList<Integer> getUnique(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], false);
        }

        Set<Integer> keys = map.keySet();

        ArrayList<Integer> retVal = new ArrayList<>();

        for (Integer val : keys) {
            retVal.add(val);
        }

        return retVal;
    }

    public static ArrayList<Integer> gce1(int[] one, int[] two) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < one.length; i++) {
            map.put(one[i], true);
        }
        ArrayList<Integer> retVal = new ArrayList<>();


        for (int i = 0; i < two.length; i++) {
            if (map.containsKey(two[i])) {
                if (map.get(two[i])) {
                    retVal.add(two[i]);
                    map.put(two[i], false);
                }
            }
        }

        return retVal;
    }

    public static ArrayList<Integer> gce2(int[] one, int[] two) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < one.length; i++) {
            if (freqMap.containsKey(one[i])) {
                int of = freqMap.get(one[i]);
                int nf = of + 1;
                freqMap.put(one[i], nf);
            } else {
                freqMap.put(one[i], 1);
            }
        }

        ArrayList<Integer> retVal = new ArrayList<>();

        for (int i = 0; i < two.length; i++) {
            if (freqMap.containsKey(two[i])) {
                if (freqMap.get(two[i]) > 0) {
                    retVal.add(two[i]);

                    int of = freqMap.get(two[i]);
                    int nf = of - 1;
                    freqMap.put(two[i], nf);
                }
            }
        }

        return retVal;

    }

    public static void zsp(int[] arr) {

    }
}
