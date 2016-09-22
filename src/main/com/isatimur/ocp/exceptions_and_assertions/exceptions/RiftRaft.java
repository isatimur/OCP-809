package main.com.isatimur.ocp.exceptions_and_assertions.exceptions;

/**
 * Created by tisachenko on 27.03.16.
 */
public class RiftRaft implements AutoCloseable {
    public RiftRaft() throws Exception {
        System.out.println("Start raft");
    }

    public void crossRapid() throws Exception {
        System.out.println("Cross rapid");
        throw new Exception("Cross Rapid exception");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Rich river bank");
        throw new Exception("CloseException");
    }
}
