package com.isatimur.ocp.package_1.cat.species;

import com.isatimur.ocp.package_1.cat.BigCat;

/**
 * Created by tisachenko on 22.02.16.
 */
public class Lynx extends BigCat {


    Lynx(String name, boolean hasFur, boolean hasPaws, long id) {
        super(name, hasFur, hasPaws, id);
    }


    public static void main(String[] args) {
        Lynx cat = new Lynx("Test Lynx", false, false, 02);
        System.out.println(cat.name);
        System.out.println(cat.hasFur);
//        System.out.println(cat.hasPaws);
//        System.out.println(cat.id);
    }

}
