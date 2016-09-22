package main.com.isatimur.ocp.package_4.collections.set_maps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by tisachenko on 11.03.16.
 */
public class ManipulateHashSet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Shreya");
        list.add("Selvan");

        HashSet<String> set = new HashSet<>();
        set.add("Harry");
        set.addAll(list);

        System.out.println(set.contains("Shreya"));
        System.out.println(set.remove("Selvan"));

        for (String e : set) {
            System.out.println(e);
        }

    }
}
