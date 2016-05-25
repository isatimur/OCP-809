package com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 22.05.16.
 */
public class ShoppingCart {
    public static void main(String[] args) {
        Book book =new Book("Java");
        Thread buy1  = new OnlineBuy(book); buy1.start();
        Thread buy2  = new OnlineBuy(book); buy2.start();
        Thread return1  = new OnlineReturn(book); return1.start();

    }
}
