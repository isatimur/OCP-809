package main.com.isatimur.ocp.package_4.generics.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Тимакс on 09.03.2016.
 */
public class Courier {
    public static void main(String[] args) {
        List<MyBook> list = new ArrayList<MyBook>();
        list.add(new MyBook("Oracle"));
        list.add(new MyBook("Java"));
        wrapList(list);

        List<String> stringList = new ArrayList<>();
        stringList.add("Paul");
        stringList.add("Shreya");
        wrapList(stringList);

        List<? super Gift> list1 = new ArrayList<Gift>();
        List<? super Gift> list2 = new ArrayList<Object>();
//        List<? super Gift> list3 = new ArrayList<MyPhone>();
        List<? super MyPhone> list3 = new ArrayList<Gift>();

        List<? super Gift> giftList = new ArrayList<Gift>();
        giftList.add(new Gift());
        giftList.add(new MyBook("1"));
        giftList.add(new MyPhone());
//        giftList.add(new Object());
        for (Object obj : giftList) {
            System.out.println(obj);
        }

    }

    public static void wrapList(List<?> list) {
        for (Object o : list) {
            System.out.println("GiftWrap: " + o);
        }
    }
}

class Gift {
}

class MyPhone extends Gift {
}

class MyBook extends Gift {
    String title;

    public MyBook(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
