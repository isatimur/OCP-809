package com.isatimur.ocp.package_1.cat;

/**
 * Created by tisachenko on 22.02.16.
 */
public class CatAdmirer {

    CatAdmirer() {

    }


    public static void main(String[] args) {
        BigCat cat = new BigCat("Kitty Admirer",true
        ,false,03);

        System.out.println(cat.hasPaws);
        System.out.println(cat.hasFur);
        System.out.println(cat.name);
//        System.out.println(cat.id);
    }
}
