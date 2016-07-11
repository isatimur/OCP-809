package com.isatimur.ocp.package_1.sub.pack_1_4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tisachenko on 12.02.16.
 */
public class MyNumber {
    int primary, secondary;

    MyNumber(int primary, int secondary) {
        this.primary = primary;

        this.secondary = secondary;

    }

    public static void main(String args[]) {
        System.out.println("//if hashCode is defining differently than equals works. \nLike in example below key attributes in overriding methods equals are different \nthan those used in hashCode method;");
        Map<MyNumber, String> map = new HashMap<>();
        MyNumber num1 = new MyNumber(2500, 100);
        MyNumber num2 = new MyNumber(2500, 200);
        System.out.println(num1.equals(num2));
        map.put(num1, "Shreya");
        System.out.println(map.get(num2));

        System.out.println("//if hashCode is defining not consistentely state like through Math.random");
        Map<AnotherNumber, String> map2 = new HashMap<>();
        AnotherNumber anum1 = new AnotherNumber(2500);
        map2.put(anum1, "Shreya");
        System.out.println(map.get(anum1));
    }

    public int hashCode() {
        return secondary;
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof MyNumber)
            return (primary == ((MyNumber)o).primary);
        else
            return false;
    }
}

class AnotherNumber {
    int primary;

    AnotherNumber(int primary) {
        this.primary = primary;
    }

    public static void main(String args[]) {

    }

    public int hashCode() {
        return (int)(Math.random() * 100);
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof AnotherNumber)
            return (primary == ((AnotherNumber)o).primary);
        else
            return false;
    }
}