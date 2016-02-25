package com.isatimur.ocp.package_1.cat;

/**
 * Created by tisachenko on 22.02.16.
 */
public class BigCat {
    public String name;
    protected boolean hasFur;
    boolean hasPaws;
    private long id;

    BigCat() {
        super();
    }

    public BigCat(String name, boolean hasFur, boolean hasPaws, long id) {
        this.name = name;
        this.hasFur = hasFur;
        this.hasPaws = hasPaws;
        this.id = id;
    }

    public static void main(String[] args) {
        BigCat bigCat = new BigCat();
        bigCat.name = "Billy";
        bigCat.hasFur = true;
        bigCat.hasPaws = true;
        bigCat.id = 01l;
        System.out.println(bigCat.name);
        System.out.println(bigCat.hasFur);
        System.out.println(bigCat.hasPaws);
        System.out.println(bigCat.id);

    }
}
