package main.com.isatimur.ocp.package_3;

/**
 * Created by Isa Timur on 7/23/16.
 */
public interface Fly {
    public final static int MAX_SPEED = 100;

    public static double calculateSpeed(float distance, int time) {
        return distance / time;

    }

    public static void main(String[] args) throws Exception {
        Fly fly = () -> 20;
        fly.land();
        System.out.println(fly.getWingSpan());

        System.out.println("================");

        Eagle eagle = new Eagle();
        eagle.land();
        System.out.println(eagle.getWingSpan());
    }

    public int getWingSpan() throws Exception;

    public default void land() {
        System.out.println("Animal is landing!");
    }
}

class Eagle implements Fly {

    @Override public int getWingSpan() {
        return 15;
    }

    @Override public void land() {
        System.out.println("Eagle is diving fast");
    }
}


