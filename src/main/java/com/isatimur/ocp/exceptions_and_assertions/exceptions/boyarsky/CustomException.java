package com.isatimur.ocp.exceptions_and_assertions.exceptions.boyarsky;

/**
 * Created by abyakimenko on 20.11.2016.
 */
public class CustomException extends RuntimeException {
    public CustomException(String rain) {
       super(rain);
    }
}
