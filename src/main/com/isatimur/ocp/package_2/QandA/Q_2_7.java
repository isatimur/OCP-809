package main.com.isatimur.ocp.package_2.QandA;

interface Floatable {
    //public and not default access modifier
    void floating();
}

/**
 * Created by tisachenko on 19.02.16.
 */
public class Q_2_7 {
    public static void main(String[] args) {
        Floatable floatable = new Floatable() {

            @Override
            public void floating() {
                System.out.println("flooaatt!");
            }
        };
        floatable.floating();
    }
}