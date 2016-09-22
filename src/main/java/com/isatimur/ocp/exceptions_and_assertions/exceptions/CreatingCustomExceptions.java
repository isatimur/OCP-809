package com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by Isa Timur on 8/21/16.
 */
public class CreatingCustomExceptions {
    public static void main(String[] args) throws CannotSwimException {
        // throw new CannotSwimException();
        // throw new CannotSwimException(new RuntimeException());
        // throw new CannotSwimException("broken fin");
    }
}

class CannotSwimException extends Exception {
    public CannotSwimException() {
        super();
    }

    public CannotSwimException(String message) {
        super(message);
    }

    public CannotSwimException(Exception e) {
        super(e);
    }
}

class DangerInTheWater extends RuntimeException {

}

class SharkInTheWater extends DangerInTheWater {

}

class Dolphin {

    void swim() throws CannotSwimException {

    }
}