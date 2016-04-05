package com.isatimur.ocp.package_4.generics;

/**
 * Created by tisachenko on 19.03.16.
 */
public class Test_9 {
    public static void main(String[] args) {
        StrLastError<String> err = new StrLastError<String>("Error");
        err.setLastError("Last error");
    }
}

class LastError<T> {
    private T lastError;

    void setLastError(T t) {
        lastError = t;
        System.out.println("LastError: setError");

    }

}

class StrLastError<S extends CharSequence> extends LastError<String> {
    public StrLastError(S s) {

    }

    @Override
    void setLastError(String lastError) {
//        super.setLastError(lastError);
        System.out.println("");
    }
}