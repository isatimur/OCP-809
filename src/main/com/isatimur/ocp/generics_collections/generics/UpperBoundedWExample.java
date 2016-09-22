package main.com.isatimur.ocp.generics_collections.generics.upper_bounded_wildcard;

import java.util.ArrayList;
import java.util.List;

interface Flyer {
    void fly();
}

/**
 * Created by Isa Timur on 8/6/16.
 */
public class UpperBoundedWExample {

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list) {
            count += number.longValue();
        }
        return count;
    }

    public static void main(String[] args) {
        List<Number> keywords = new ArrayList<>();
        keywords.add(2);
        keywords.add(23);
        System.out.println(total(keywords));

    }

    private void anyFlyer(List<Flyer> flyer) {

    }

    private void groupOfFlyers(List<? extends Flyer> flyer) {

    }

}

class HangGlider implements Flyer {
    @Override public void fly() {

    }
}

class Goose implements Flyer {
    @Override public void fly() {

    }
}

