package main.com.isatimur.ocp.exceptions_and_assertions.assertions;

/**
 * Created by Isa Timur on 8/22/16.
 */
public class Assertions {
    public static void main(String[] args) {
        int numGuests = -5;
        assert numGuests > 0;
        System.out.println(numGuests);
    }
}
