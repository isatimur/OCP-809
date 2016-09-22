package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by tisachenko on 27.03.16.
 */
public class SuppressedException {
    public static void main(String[] args) throws Exception {
        try (RiftRaft raft = new RiftRaft()) {
            raft.crossRapid();
        }
        catch (Exception e) {
            System.out.println("Exception caught: " + e);
            Throwable[] exc = e.getSuppressed();
            if (exc.length > 0) {
                System.out.println(exc[0]);
            }
        }
    }
}
