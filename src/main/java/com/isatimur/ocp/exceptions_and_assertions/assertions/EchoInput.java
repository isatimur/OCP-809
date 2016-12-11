package com.isatimur.ocp.exceptions_and_assertions.assertions;

public class EchoInput {
    public static void main(String[] args) {

        if (args.length <= 3) {
            assert false;
        }
        System.out.println(args[0] + args[1] + args[2]);
    }
}