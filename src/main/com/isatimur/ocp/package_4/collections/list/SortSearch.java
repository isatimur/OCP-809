package main.com.isatimur.ocp.package_4.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tisachenko on 17.03.16.
 */
public class SortSearch {
    static final Comparator<Integer> INT_COMPARATOR = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9999);
        list.add(10);
        list.add(55);
        list.add(28);

        Collections.sort(list, null);
        System.out.println(Collections.binarySearch(list, 55));

        Collections.sort(list, INT_COMPARATOR);
        System.out.println(Collections.binarySearch(list, 55));

    }
}
