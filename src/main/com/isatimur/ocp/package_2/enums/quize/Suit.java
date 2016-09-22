package main.com.isatimur.ocp.package_2.enums.quize;

import java.awt.Color;

/**
 * Created by tisachenko on 24.05.16.
 */
public enum Suit {
    HEART(Color.RED), DIAMOND(Color.RED), SPADE(Color.BLACK), CLUB(Color.BLACK);
    private Color color;

    Suit(Color color) {
        this.color = color;
    }
}

enum Test {
    TEST, TEST2
}
//public enum Suit {
//    HEART, DIAMOND,SPADE,CLUB;
//    private Color color;
//    public final Suit(Color color){
//        this.color = color;
//    }
//}

