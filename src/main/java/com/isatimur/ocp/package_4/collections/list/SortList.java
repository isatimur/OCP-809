package com.isatimur.ocp.package_4.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tisachenko on 16.03.16.
 */
public class SortList {
    public static void main(String args[]) {
//        List<Integer> integers = new ArrayList<>();
//        integers.add(new Integer(200));
//        integers.add(new Integer(87));
//        integers.add(new Integer(999));
//        for (Integer i : integers) {
//            System.out.println(i);
//        }
//        System.out.println("After calling Collections.sort()");
//        Collections.sort(integers);
//        for (Integer i : integers) {
//            System.out.println(i);
//        }

        Star s1 = new Star("Sun", 7777.77);
        Star s2 = new Star("Sirus", 99999.99);
        Star s3 = new Star("Pilatium", 222.22);

        List<Star> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Collections.sort(list);
        list.add(new Star("Litmier", 4444.44));
        Collections.reverse(list);
        for (Star star : list) {
            System.out.println(star.toString());
        }

    }

}

class Star implements Comparable<Star> {

    String name;
    double mass;

    public Star(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    @Override
    public int compareTo(Star o) {
        return (int)(this.mass - o.mass);
    }

    @Override
    public String toString() {
        return "Star{" +
            "name='" + name + '\'' +
            ", mass=" + mass +
            '}';
    }
}
