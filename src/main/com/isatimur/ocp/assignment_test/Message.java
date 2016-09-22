package main.com.isatimur.ocp.assignment_test;

public abstract class Message {
    public String recipient;

    //    public abstract final void sendMessage();
    public abstract void sendMessage();

    public static void main(String[] args) {
        Message m = new TextMessage();
        m.recipient = "1234567890";
        m.sendMessage();
    }

    static class TextMessage extends Message {
        public final void sendMessage() {
            System.out.println("Text message to " + recipient);
        }
    }
}

//    A.  Text message to null.
//    B.  Text message to 1234567890.
//    C.  A compiler error occurs on line 1.
//    D.  A compiler error occurs on line 3.

// ============== E.  A compiler error occurs on line 7. ==============

//    F.  A compiler error occurs on another line.