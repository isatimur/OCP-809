package main.com.isatimur.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Isa Timur on 8/24/16.
 */
public class ZooInfo {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Printing record: " + i);
                }
            });
            service.submit(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        }
        finally {
            if (service != null)
                service.shutdown();
        }
    }
}
