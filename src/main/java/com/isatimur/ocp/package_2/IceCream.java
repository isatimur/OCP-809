package com.isatimur.ocp.package_2;

/**
 * Created by tisachenko on 17.02.2016.
 */
enum IceCream {

    VANILLA("white"),
    STRAWBERRY("pink"),
    WALNUT("brown") {
        public String toString() {
            return "WALNUT is Brown in color";
        }
    }, CHOCOLATE("dark brown");

    private String color;

    IceCream(String color) {

        this.color = color;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "color='" + color + '\'' +
                '}';
    }
    //    VANILLA, STRAWBERRY, WALNUT, CHOCOLATE;
//    private String color;
//
//    @Override
//    public String toString() {
//        return "IceCream{" +
//                "color='" + color + '\'' +
//                '}';
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
}
