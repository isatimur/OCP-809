package com.isatimur.ocp.package_3.lambda;

/**
 * Created by tisachenko on 06.03.16.
 */
public class PigLatin {
    interface SuffixFunction {
        void call();
    }

    public static void main(String[] args) {
        String word = "hello";
        SuffixFunction function = ()-> System.out.printf(word+"ay");
//        word="e"; cannot be used here because it effectivly final
        function.call();

    }
}
