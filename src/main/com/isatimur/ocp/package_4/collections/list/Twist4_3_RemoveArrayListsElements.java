package main.com.isatimur.ocp.package_4.collections.list;

import java.util.ArrayList;

/**
 * Created by tisachenko on 11.03.16.
 */
public class Twist4_3_RemoveArrayListsElements {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer age1 = 20;
        Integer age2 = 20;
        list.add(age1);
        list.add(age2);
        System.out.println("size:" + list.size());
        age1 = 30;
        list.remove(age1);
//        list.remove(20);
        System.out.println(list.size());

    }
}
