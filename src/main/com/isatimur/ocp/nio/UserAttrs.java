package main.com.isatimur.ocp.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * Created by tisachenko on 18.04.16.
 */
public class UserAttrs {

    public static void main(String[] args) throws IOException {
        Path file = Paths.get("object.txt");

        UserDefinedFileAttributeView view = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);
        writeAttr(view, "delete", true);
        if (readAttr(view, "delete")) {
            Files.delete(file);
        }
    }

    static void writeAttr(UserDefinedFileAttributeView view, String attr, boolean value) throws IOException {
        if (value) {
            view.write(attr, Charset.defaultCharset().encode("true"));
        }
        else {
            view.write(attr, Charset.defaultCharset().encode("false"));
        }

    }

    static boolean readAttr(UserDefinedFileAttributeView view, String attr) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(view.size(attr));
        view.read(attr, buffer);
        buffer.flip();
        String value = Charset.defaultCharset().decode(buffer).toString();
        return (value.equalsIgnoreCase("true"));
    }
}