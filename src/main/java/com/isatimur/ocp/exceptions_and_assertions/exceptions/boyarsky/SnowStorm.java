package com.isatimur.ocp.exceptions_and_assertions.exceptions.boyarsky;

public class SnowStorm {

    static class Walk implements AutoCloseable {

        @Override
        public void close() {
            throw new RuntimeException("snow");
//            throw new IOException("snow");// java.io.IOException; must be caught or declared to be thrown
        }
    }

    public static void main(String[] args) {
        try (Walk walk1 = new Walk();
             Walk walk2 = new Walk();) {
            throw new CustomException("rain");
//            throw new RuntimeException("rain");
        } catch (Exception e) {
            System.out.println(e.getMessage()
                    + " " + e.getSuppressed().length);
        }
    }
}