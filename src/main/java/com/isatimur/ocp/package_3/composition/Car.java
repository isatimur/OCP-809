package com.isatimur.ocp.package_3.composition;

/**
 * Created by tisachenko on 01.03.16.
 */
public class Car {
    Engine engine;
    Wheels[] wheels = new Wheels[5];
}

class Engine {
}

class Wheels {
}