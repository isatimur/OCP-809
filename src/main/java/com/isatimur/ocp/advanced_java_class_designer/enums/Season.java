package com.isatimur.ocp.advanced_java_class_designer.enums;

public enum Season {

    WINTER("Low") {
        @Override
        public void printHours() { System. out .println("9am-3pm"); }
    }, SPRING("Medium") {
        @Override
        public void printHours() { System. out .println("9am-5pm"); }
    }, SUMMER("High"),
    FALL("Medium") {
        @Override
        public void printHours() { System. out .println("9am-3  5pm"); }
    };

    private String expectedVisitors;

    Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }

//    public abstract void printHours();
    public void printHours() { System.out.println("default hours"); }
}