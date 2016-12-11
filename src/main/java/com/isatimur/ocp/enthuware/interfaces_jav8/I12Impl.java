package com.isatimur.ocp.enthuware.interfaces_jav8;

import java.io.FileNotFoundException;

/**
 * Created by abyakimenko on 11.12.2016.
 * When interfaces are involved, more than one method declaration may be overridden by a single overriding declaration.
 * In this case, the overriding declaration must have a throws clause that is compatible with ALL the overridden
 * declarations.
 */
public class I12Impl implements I1, I2 {

    @Override
//    public void m1() throws IOException {
    public void m1() throws FileNotFoundException {// выбираем подкласс IOException, это удовлетворит обоим методам

    }
}
