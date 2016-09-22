package main.com.isatimur.ocp.package_3.coupling.step2;

/**
 * Created by tisachenko on 01.03.16.
 */
public class TechnicalAuthor implements Author {

    String skypeName;
    String name;

    @Override
    public String getSkypeId() {
        return skypeName;
    }
}
