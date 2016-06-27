package com.isatimur.ocp.package_3.lambda;

/**
 * Created by tisachenko on 06.03.16.
 */
public class UseLambdaFunctions {
    public static void main(String[] args) {
        LambdaInterface lambdaInterface = () -> System.out.println("Yahoo!");
        lambdaInterface.call();
    }
}
