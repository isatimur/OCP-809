package com.isatimur.ocp.threads;

/**
 * Created by tisachenko on 22.05.16.
 */
public class OnlineBuy extends Thread{
    private Book book;

    public OnlineBuy(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        book.newSale();
        System.out.println(book.counterSold);
    }
}
