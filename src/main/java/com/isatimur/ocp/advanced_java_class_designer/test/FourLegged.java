package com.isatimur.ocp.advanced_java_class_designer.test;

//Both objects are BabyRhino objects. Virtual method invocation says that the subclass
//method gets called at runtime rather than the type in the variable reference. However, we
//550 Appendix A ■ Answers to Review Questions
//are not calling methods here. We are referring to instance variables. With instance variables,
//the reference type does matter.

public class FourLegged {
    String walk = "walk,";

    static class BabyRhino extends FourLegged {
        String walk = "toddle,";
    }

    public static void main(String[] args) {
        FourLegged f = new BabyRhino();
        BabyRhino b = new BabyRhino();
        System.out.println(f.walk);
        System.out.println(b.walk);
    }
}