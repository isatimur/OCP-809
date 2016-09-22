package com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by tisachenko on 28.03.16.
 */
public class SolyankaExceptions {
    public static void main(String[] args) {
        new AutoClose2().useCloseableResources();
    }

}

class MyAutocloseableResource implements AutoCloseable {

    MyAutocloseableResource() {
        System.out.println("Constructor resource");
    }

    @Override
    public void close() {
        System.out.println("CLose called");
    }
}

class AutoClose2 {
    void useCloseableResources() {
        try (MyAutocloseableResource resource = new MyAutocloseableResource();) {
            System.out.println("within try with resources");
        }
        finally {
            System.out.println("finally");
        }
    }
}