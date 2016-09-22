package main.com.isatimur.ocp.package_2.QandA;

/**
 * Created by tisachenko on 19.02.16.
 */
enum Q_2_13 {
    RED;

    static {
        System.out.println("Static init");
    }

    {
        System.out.println("Init block");
    }

    Q_2_13() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        Q_2_13 q_2_13 = Q_2_13.RED;
    }

}

