package com.isatimur.ocp.package_4;

import java.util.UUID;

/**
 * Created by tisachenko on 09.03.16.
 */
public class UseGenericType {
    public static void main(String[] args) {
        Parcel<String> parcel = new Parcel<>("Hello");
        System.out.println(parcel.getT());
        GenericBookParcel<String> var1 = new GenericBookParcel<>(new Book());
       System.out.println(var1.getT());
//        NonGenericPhoneParcel<String> var = new NonGenericPhoneParcel<>();
    }
}
class Parcel <MyClass>{
    MyClass t;

    public Parcel(MyClass t) {
        this.t = t;
    }

    public void setT(MyClass t) {
        this.t = t;
    }

    public MyClass getT() {
        return t;
    }
}

class MyClass{

}
class Book{
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
class GenericBookParcel<X> extends Parcel<Book>{

    public GenericBookParcel(Book t) {
        super(t);
    }
}

class NonGenericPhoneParcel extends Parcel<Phone> {
    public NonGenericPhoneParcel(Phone t) {
        super(t);
    }
}