package main.com.isatimur.ocp.package_2;

/**
 * Created by tisachenko on 14.02.16.
 */
public class StaticInitializers {
    static int rate = 0;

    static {
        rate = 10;
    }

    static {
        ++rate;
    }

    StaticInitializers() {
        System.out.println(rate);
    }

    public static void main(String[] args) {
        new StaticInitializers();
    }

}
//Comments are stayed below

/**
 * It is awesomness in action, because the real code that Java compiler gonna reorder execution process. static int
 * rate; static { rate = 10; rate = 0; ++rate; }
 **/