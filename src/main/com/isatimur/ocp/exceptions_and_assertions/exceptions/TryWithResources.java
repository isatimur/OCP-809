package com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by developer on 8/22/16.
 */
public class TryWithResources {
    public static void main(String[] args) {

        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            System.out.println("put turkeys in");
        }
        catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
        }

        System.out.println("=========Suppresed exceptions=========");

        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("turkeys ran off");
        }
        catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t.getMessage());
            }
        }

        try {
            System.out.println("=========Suppresed exception but catch should be looking for primary exception=========");
            try (JammedTurkeyCage t = new JammedTurkeyCage()) {
                throw new RuntimeException("turkey ran off");

            }
            catch (IllegalStateException e) { //this type of exception does not match with primary one!
                System.out.println("caught: " + e.getMessage());
            }
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=========two resources=========");

        try (JammedTurkeyCage j1 = new JammedTurkeyCage();
             JammedTurkeyCage j2 = new JammedTurkeyCage()) {
            System.out.println("turkeys entered cages");
        }
        catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t.getMessage());
            }
        }

        try {
            System.out.println("==========Exception is Out of try with scope========");

            try (JammedTurkeyCage t1 = new JammedTurkeyCage()) {
                throw new IllegalStateException("turkeys ran off");
            }
            finally {
                throw new RuntimeException("and we couldn't fnd them");
            }
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=================Ordering================");

        try (Auto auto = new Auto(1); Auto auto2 = new Auto(2)) {
            throw new RuntimeException();

        }
        catch (Exception e) {
            System.out.println("ex");
        }
        finally {
            System.out.println("finally");
        }
    }

}

class JammedTurkeyCage implements AutoCloseable {

    @Override public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }

}

class Auto implements AutoCloseable {
    int num;

    public Auto(int num) {
        this.num = num;
    }

    @Override public void close() {

        System.out.println("Close: " + num);
    }
}