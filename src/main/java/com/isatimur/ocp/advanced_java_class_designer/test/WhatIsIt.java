package com.isatimur.ocp.advanced_java_class_designer.test;

/**
 * Created by abyakimenko on 28.09.2016.
 */
public class WhatIsIt {

    interface Furry {
    }

    class Chipmunk {
    }

    class FurryChipmunk implements Furry {
    }

    public static void main(String[] args) {

//      Chipmunk c = new Chipmunk();  // cannot be referenced from a static context

        Chipmunk c = new WhatIsIt().new Chipmunk();  // cannot be referenced from a static context
        int result = 0;

        if (c instanceof Furry) result += 1;
        if (c instanceof Chipmunk) result += 2;
        // if (c instanceof FurryChipmunk) result += 4; // не находятся в иерархии наследования
        if (null instanceof FurryChipmunk)
            result += 4;// не ошибка, но никогда не зайдёт сюда

        System.out.println(result);
    }

}
