package main.com.isatimur.ocp.assignment_test;

import java.io.*;

public class Tail {
}

class Bird implements Serializable {

    private String name;
    private transient int age;
    private Tail tail;

    public String getName() {
        return name;
    }

    public Tail getTail() {
        return tail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTail(Tail tail) {
        this.tail = tail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void main(String[] args) {
        try (InputStream is = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("birds.dat")))) {
//            Bird bird = is.readObject();
//            Bird bird = is.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//A.  It compiles and runs without issue.
//B.  The code will not compile because of line 3.
//C.  The code will not compile because of line 5.

//D.  ================ The code will not compile because of lines 16–17. ================
//E.  ================ The code will not compile because of line 18. ================

//F.  It compiles but throws an exception at runtime.