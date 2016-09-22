package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by tisachenko on 26.03.16.
 */
public class TestVariableInput {
    public static void main(String[] args) {
        try {
            int a = 10;
            if (a <= 10)
                throw new Exception1();
            else
                throw new Exception2();
        }
        catch (Exception1 | Exception2 e) {
//            System.out.println(e.info); will not compile because common exception is of Exception type
        }
    }
}
