package com.isatimur.ocp.package_3.different_package;

import com.isatimur.ocp.package_3.MyInterfaces;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tisachenko on 29.02.16.
 */
public class TestDefaultInterface {
    public static void main(String[] args) {
        MyInterfaces interfaces = new MyInterfaces() {
            @Override
            public String toString() {
                return "interfaces";
            }
        };
        MyInterfaces.interface2 interface2 = new MyInterfaces.interface2() {
            @Override
            public String toString() {
                return "interfaces2";
            }
        };
        MyInterfaces.interface4 interface4 = new MyInterfaces.interface4() {
            @Override
            public String toString() {
                return "interfaces4";
            }
        };

        MyInterfaces.MyInterface1 myInterface1 = new MyInterfaces.MyInterface1() {
            @Override
            public String toString() {
                return "myInterface1";
            }
        };

        System.out.println(interfaces);
        System.out.println(interface2);
        System.out.println(interface4);
        System.out.println(myInterface1);
        Stream stream = Stream.empty();
        List list;

    }
}
