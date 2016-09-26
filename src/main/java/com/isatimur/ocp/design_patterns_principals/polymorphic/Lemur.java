package com.isatimur.ocp.design_patterns_principals.polymorphic;

public class Lemur extends Primate implements HasTail {
    public int age = 10;

    @Override
    public boolean isTailStriped() {
        return false;
    }

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        HasTail hasTail = lemur;
        HasTail hasTail1 = new Lemur();
        Primate primateOrigin = new Primate();


        System.out.println(hasTail.isTailStriped());

        Primate primate = lemur;

        Lemur lemur3 = (Lemur)primate;
        System.out.println(lemur3.age);

        System.out.println(primate.hasHair());
    }
}