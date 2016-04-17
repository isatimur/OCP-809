package com.isatimur.ocp.package_3.different_package;

import com.isatimur.ocp.package_3.ReviewInterfaces;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tisachenko on 29.02.16.
 */
public class TestDefaultInterface {
    public static void main(String[] args) {
        ReviewInterfaces interfaces = new ReviewInterfaces() {
            @Override
            public String toString() {
                return "interfaces";
            }
        };
        ReviewInterfaces.interface2 interface2 = new ReviewInterfaces.interface2() {
            @Override
            public String toString() {
                return "interfaces2";
            }
        };
        ReviewInterfaces.interface4 interface4 = new ReviewInterfaces.interface4() {
            @Override
            public String toString() {
                return "interfaces4";
            }
        };

        ReviewInterfaces.MyInterface1 myInterface1 = new ReviewInterfaces.MyInterface1() {
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
