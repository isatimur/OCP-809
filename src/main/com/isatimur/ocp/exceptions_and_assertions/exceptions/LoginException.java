package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by tisachenko on 25.03.16.
 */
class LoginException extends RuntimeException {
    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }
}