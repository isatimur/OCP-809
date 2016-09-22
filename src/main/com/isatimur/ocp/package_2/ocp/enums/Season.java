package main.com.isatimur.ocp.package_2.ocp.enums;

/**
 * Created by tisachenko on 26.02.16.
 */
public enum Season {
    WINTER {
        public void printHours() {
            System.out.println("9am-3pm");
        }
    },
    SPRING {
        public void printHours() {
            System.out.println("9am-5pm");
        }
    },
    SUMMER {
        public void printHours() {
            System.out.println("9am-7pm");
        }
    },
    FALL {
        public void printHours() {
            System.out.println("9am-5pm");
        }
    };

    public static void main(String[] args) {
        Season.WINTER.printHours();
    }

    public abstract void printHours();
}
