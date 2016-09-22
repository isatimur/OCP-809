package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by Isa Timur on 7/19/16.
 */
public class Copper extends Metal {
    Copper(int a) {
        System.out.print("Copper-");
    }

    public static void main(String args[]) {
        new Copper(101);
    }
}

class Metal {
    {
        try {
            throw new RuntimeException();
        }
        catch (Exception e) { // here was no catch exception
            System.out.print("exception-");
        }
        finally {
            System.out.print("finally-");
        }
    }

    Metal() {
        System.out.print("Metal-");
    }
}
