package com.isatimur.ocp.package_4;

/**
 * Created by tisachenko on 09.03.16.
 */
public abstract class Courier {
    public <E> void deliver(E[] array) {
        for (E item : array) {
            System.out.println("Delivering - " + item);
        }
    }

    public static void main(String[] args) {
        Courier courier = new Courier() {
            @Override
            public <E> void deliver(E[] array) {
                super.deliver(array);
            }
        };
        courier.deliver(new String[]{"fruits","meat","vegetables"});

        MyPhone<Double> c = new MyPhone<Double>("Android");
        System.out.println(c.getObject().toString());
    }
}

interface MapMaterial<X>{
    <T> void mapMaterial(T value);

}
class MyPhone<X> {
    X value;
    Object object;
    <T> MyPhone(T t){
        System.out.println("MyPhone T");
        object = t;
    }

    public Object getObject() {
        return object;
    }
}