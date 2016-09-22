package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by tisachenko on 25.03.16.
 */
public class UserActivity {
    public void login(String name, String passwd) {
        if (!findInDatabase(name, passwd)) {
            throw new LoginException("Invalid username password");
        }
    }

    private boolean findInDatabase(String name, String passwd) {

        return false;
    }
}
