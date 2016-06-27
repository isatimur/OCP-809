package com.isatimur.ocp.package_4.generics.mixing_raw_types;

import java.util.Stack;

/**
 * Created by tisachenko on 11.03.16.
 */
public class Interoperability {
    public static void pushItems(Stack stackParams, Object item) {
        stackParams.push(item);
    }

    public static void main(String[] args) {
        Stack<String> stackObj = new Stack<>();
        stackObj.push("Antoha");
        pushItems(stackObj, new Integer(77));
        //ClassCastException - Integer to String
        String value = stackObj.pop();
        System.out.println(value);
    }
}
