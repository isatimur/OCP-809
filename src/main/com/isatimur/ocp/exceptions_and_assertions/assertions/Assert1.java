package main.com.isatimur.ocp.exceptions_and_assertions.assertions;

/**
 * Created by tisachenko on 28.03.16.
 */
public class Assert1 {
    public static void main(String[] args) {
        new Assert1().printReport();
    }

    void printReport() {
        int pages = 100;
        while (pages >= 100 && pages < 199) {
            if (pages < 300) {
                pages++;
            }
        }

        System.out.println(pages);
        assert (pages < 200) : "Error: pages should NOT be < 200";
    }
}
