package main.main.com.isatimur.ocp.advanced_java_class_designer;

enum Metal {
    COPPER, GOLD, SILVER;

    static {
        System.out.print("static:");
    }

    Metal() {
        System.out.print("constructor:");
    }

    public static void main(String args[]) {
        System.out.print(Metal.COPPER + ":");
    }

}

/**
 * Created by Isa Timur on 7/19/16.
 */
public class EnumTypes {
    public static void main(String args[]) {
        System.out.print(Metal.COPPER + ":");
//        System.out.print(new MetalI().COPPER);
    }

}

//class MetalI {
//    MetalI COPPER = new MetalI();
//    MetalI GOLD = new MetalI();
//    MetalI() {
//        System.out.print("constructor:");
//    }
//    static {
//        System.out.print("static:");
//    }
//    public static void main(String args[]) {
//        System.out.print(new MetalI().COPPER);
//    }
//
//    @Override
//    public String toString() {
//        return "ZHELEZYAKA";
//    }
//}