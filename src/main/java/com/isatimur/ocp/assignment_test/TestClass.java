package com.isatimur.ocp.assignment_test;

/**
 * Created by abyakimenko on 18.11.2016.
 */
public class TestClass {

    void test() {
       // норм вариант нисходящего приведения типов
        A parent = new B();

//        A parent = new A();
        B child = (B) parent;
    }

    public static void main(String[] args) {

        new TestClass().test();
        A[] parent = new A[1];
        B[] child = (B[]) parent;

        A[] a, a1;
        B[] b;

        a = new A[10];
        a1 = a;

        b = new B[20];
        a = b;

        // B[] b11 = (B[]) a1;
//        Downcasting - нисходящее приведение, то есть приведение от предка к потомку предку подтипу возможно если только
//        исходная переменная является подтипом приводимого типа. Ошибка может возникать runtime или на этапе компиляции. Скажем:
        C[] c11 = (C[]) b;

        Double aDouble = new Double(1.0);
        Number n = (Number) aDouble; //разрешено, поскольку Double является подтипом Number

        Object object = new Object();// разрешено во время компиляции, поскольку тип переменной object
        String s = (String) object;  // RuntimeException может быть String'ом, но это выяснится только в runtime


        // List<String> stringList = new ArrayList<>();
        // List <- ArrayList
//        List coll = new ArrayList();
//        List coll2 = (LinkedList) coll;
//        LinkedList coll3 = (LinkedList) coll;


        // ссылка a1 смотрит на объект с типом A - родительский к B
        // A <- B. Попытка привести родительский тип к дочернему
        // такое возможно если исходная переменная является подтипом приводимого типа
        // b = (B[]) a1;
    }



    class A {
    }

    class B extends A {
    }

    class C extends B {
    }

    /*Такое приведение типов не сработает и будет выброшено исключение. ArrayList нельзя привести к типу LinkedList. Смотрите дерево подчиненности.

    Касательно самой операции приведения типов (или cast'а) - исходный объект - тип не меняет, просто меняется ссылка на него.
    P.S. Подтекст вопроса в том, что якобы ваш col1 имеет тип List, а раз он имеет тип List то можно провести кастинг на LinkedList,
    который также имеет интерфейс List. Хитрый у вас интервьюер :)

    Update

    Правила кастинга такие:

    Downcasting - нисходящее приведение, то есть приведение от предка к потомку предку подтипу возможно если только
    исходная переменная является подтипом приводимого типа. Ошибка может возникать runtime или на этапе компиляции. Скажем:

    Object object;
    String s=(String )object; //разрешено, поскольку тип переменной object
    //может быть String'ом, но это выяснится только в runtime

    Double object=new Double(1.0);
    String s = (String) object; //ошибка будет на этапе компиляции поскольку тип
    object известен компилятору и он не приводим к типу String

    Object object = new Double(1.0);
    Number n=(Number) object; //разрешено, поскольку Double является подтипом Number
    Upcasting - восходящее приведение типов или приведение типов от потомка к предку, разрешено всегда.

    Запрещено приведение типов не "лежащих" в одной иерархии (как в случае Double и String или LinkedList и ArrayList)*/

}
