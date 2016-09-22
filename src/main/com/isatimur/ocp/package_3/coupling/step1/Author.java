package main.com.isatimur.ocp.package_3.coupling.step1;

/**
 * Created by tisachenko on 01.03.16.
 */
class Author {
    String name;
    String skypeID;

    public String getSkypeID() {
        return skypeID;
    }
}

class Editor {
    private String upCall;

    public void clearEditingDoubts(Author author) {
        setUpCall(author.getSkypeID());
        converse(author);
    }

    void converse(Author author) {

    }

    void setUpCall(String upCall) {
        this.upCall = upCall;
    }

}
