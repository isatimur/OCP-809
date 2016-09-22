package main.com.isatimur.ocp.exceptions_and_assertions.assertions;

/**
 * Created by tisachenko on 28.03.16.
 */
public class TrickAssert {
    public static void main(String[] args) {
        boolean b = false;
        assert (b = true) : new Person();
    }
}

class Person {
    @Override
    public String toString() {
        return "Pirates of the Caribien";
    }
}