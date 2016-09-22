package com.isatimur.ocp.package_2;

///**
// * Created by tisachenko on 16.02.2016.
// */
//final class Level extends Enum implements Comparable, Serializable {
//    /**
//     * Sole constructor.  Programmers cannot invoke this constructor.
//     * It is for use by code emitted by the compiler in response to
//     * enum type declarations.
//     *
//     * @param name    - The name of this enum constant, which is the identifier
//     *                used to declare it.
//     * @param ordinal - The ordinal of this enumeration constant (its position
//     *                in the enum declaration, where the initial constant is assigned
//     */
//    protected Level(String name, int ordinal) {
//        super(name, ordinal);
//    }
//
//    public static final Level BEGINNER;
//    public static final Level INTERMEDIATE;
//    public static final Level EXPERT;
//
//    private static final Level $VALUES[];
//
//    static {
//        BEGINNER = new Level("BEGINNER", 0);
//        INTERMEDIATE = new Level("INTERMEDIATE", 1);
//        EXPERT = new Level("EXPERT", 2);
//        $VALUES = (new Level[]{BEGINNER, INTERMEDIATE, EXPERT});
//    }
//
//    public static Level[] values() {
//        return (Level[]) $VALUES.clone();
//    }
//
//    public static Level valuesOf(String name) {
//        return (Level) Enum.valueOf(Level.class, name);
//    }
//}

enum Level {

    BEGINNER;

    static {
        System.out.println("static init block");
    }

    Level() {
        System.out.println("constructor");
    }

    public static void main(String... args) {
        System.out.println(Level.BEGINNER);
    }
}