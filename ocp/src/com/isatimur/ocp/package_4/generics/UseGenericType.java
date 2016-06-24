package com.isatimur.ocp.package_4.generics;

import java.util.UUID;

/**
 * Created by tisachenko on 09.03.16.
 */
public class UseGenericType {
    public static void main(String[] args) {
        Parcel<String> parcel = new Parcel<>();
        parcel.setT("Hello");
        System.out.println(parcel.getT());
        GenericBookParcel<String> var1 = new GenericBookParcel<>(new Book());
        System.out.println(var1.getT());
        var1.deliver("Hello");
        var1.<Number>deliver(new Double(10));
//        NonGenericPhoneParcel<String> var = new NonGenericPhoneParcel<>();
    }
}

class Parcel<T> {
    T t;

//    public Parcel(T t) {
//        this.t = t;
//    }

    public <X> void deliver(X x) {
        System.out.println(x.getClass());
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class MyClass {

}

class Book {
    /**
     * Created by tisachenko on 09.03.16.
     */
    @Override
    public String toString() {
        return UUID.randomUUID().toString();
    }
}

class Phone {
}

class GenericBookParcel<X> extends Parcel<Book> {

    public GenericBookParcel(Book t) {
//        super(t);
//    }
    }
}

class NonGenericPhoneParcel extends Parcel<Phone> {
//    public NonGenericPhoneParcel(Phone t) {
//        super(t);
//    }
}

class BookParcel extends Parcel<Book> {

    public void setT(Book book) {
        super.setT(book);
    }
}