package main.com.isatimur.ocp.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by tisachenko on 26.05.16.
 */
public class ChannelsUsage {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("./ReadChars.java", "rw");
        FileChannel channel = file.getChannel();
        String dsd = "dasdasdasdasdasdasdasdasdasdasd\r\nsdfsdfsdkfnkasdfasdjgjnasbndg34uiretuweriytuyerutyuierytyeruit\r\nsdfsdf" +
            "sdfsdfsdfsdfsdff4gGDDDDDDDDDDDDSFSDFDF";
        ByteBuffer buffer = ByteBuffer.allocate(48);
        byte[] bytes = dsd.getBytes();
//        while()
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        while (byteBuffer.hasRemaining()) {
            buffer.put(byteBuffer.get());
            buffer.flip();
            int bufRead = channel.write(buffer);
            buffer.clear();
        }

//      channel.write(buffer);
//        channel.close();

//        buffer.rewind();
        int bufRead = channel.read(buffer, 0);
        while (bufRead != -1) {
//            System.out.println("Read: " + bufRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            bufRead = channel.read(buffer);
        }
        file.close();
//        channel.
    }
}
