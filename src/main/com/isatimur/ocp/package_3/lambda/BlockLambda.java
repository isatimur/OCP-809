package main.com.isatimur.ocp.package_3.lambda;

/**
 * Created by tisachenko on 06.03.16.
 */
public class BlockLambda {
    public static void main(String[] args) {
        LambdaFunction lambdaFunction = (int kind) -> {
            if (kind % 2 == 0) {
                return "even";
            }
            else {
                return "odd";
            }
        };
        System.out.println(lambdaFunction.intKind(53));
    }

    interface LambdaFunction {
        String intKind(int kind);
    }
}
