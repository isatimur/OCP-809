package com.isatimur.ocp.package_4.bounded;

/**
 * Created by tisachenko on 09.03.16.
 */
public abstract class Gift {
    abstract double getWeight();

    public static void main(String[] args) {
        Parcel<Gift,Wrappable,Exchangeble> parcel = new Parcel<>();
        parcel.set(new Book());
        parcel.shipParcel();
        parcel.set(new Phone());
        parcel.shipParcel();

    }

    @Override
    public String toString() {
        return "Gift with weight:" + getWeight();
    }

}

class Book extends Gift {
    @Override
    public double getWeight() {
        return 3.2;
    }

    @Override
    public String toString() {
        return "Book with weight:" + getWeight();
    }
}

class Phone extends Gift {
    @Override
    double getWeight() {
        return 10.1;
    }

    @Override
    public String toString() {
        return "Phone with weight:" + getWeight();
    }
}

class Parcel<T extends Gift,Wrappable,Exchangeble> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public void shipParcel() {
        if (t instanceof Gift) {
            if (t.getWeight() > 10) {
                System.out.println("Ship by courier ABC");
            } else {
                System.out.println("Ship by courier XYZ");
            }
        } else {
            System.out.println("Wrappable or Exchangeble");
        }
    }
}

interface Wrappable {
}

interface Exchangeble {
}

class AThing implements Wrappable {

}

class AnotherThing implements Exchangeble {

}