package com.isatimur.ocp.exceptions_and_assertions.exceptions;

import java.io.FileNotFoundException;

/**
 * Created by tisachenko on 25.03.16.
 */
class ThrowExceptions {
    void method1() throws Error {
    }

    void method2() throws Exception {
    }

    void method3() throws Throwable {
    }

    void method4() throws RuntimeException {
    }

    void method5() throws FileNotFoundException {
    }
}

class HandleExceptions {
    void method6() {
        try {
        } catch (Error e) {
        }
    }

    void method7() {
        try {
        } catch (Exception e) {
        }
    }

    void method8() {
        try {
        } catch (Throwable e) {
        }
    }

    void method9() {
        try {
        } catch (RuntimeException e) {
        }
    }

    void method10() {
        try {
        } catch (Exception e
            //FileNotFoundException e will not compile  But a try block can’t define a catch
//        block for a checked exception (other than Exception )
                ) {
        }
    }
}