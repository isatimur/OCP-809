package com.isatimur.ocp.advanced_java_class_designer;

/**
 * Created by tisachenko on 11.02.16.
 */
public class OverloadOverrideHide {

    public static void main(String[] args) {

    }

}
//a) valid
//class Book {
//    static void print(){}
//}
//class CourseBook extends Book{
//    static void print(){}
//}

//b) cannot be compiled in CourseBook
//class Book {
//    static void print(){}
//}
//class CourseBook extends Book{
//    void print(){}
//}

//c) cannot be compiled
//class Book {
//    void print(){}
//}
//class CourseBook extends Book{
//    static void print(){}
//}

//d) here it compile and override method inherited from Book class in CourseBook class
class Book {
    void print(){}
}
class CourseBook extends Book{
    void print(){}
}
