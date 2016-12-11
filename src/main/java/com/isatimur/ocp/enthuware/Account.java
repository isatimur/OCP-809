package com.isatimur.ocp.enthuware;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

class Account {
    private String id;

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //accessors not shown
}

class BankAccount extends Account {
    private double balance;

    public BankAccount(String id, double balance) {
        super(id);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //accessors not shown      
    public static void main(String[] args) {
        Map<String, Account> myAccts = new HashMap<>();
        myAccts.put("111", new Account("111"));
        myAccts.put("222", new BankAccount("111", 200.0));

        BiFunction<String, Account, Account> bif =
                (a1, a2) ->
                        a2 instanceof BankAccount ? new BankAccount(a1, 300.0) : new Account(a1); //1                  
        myAccts.computeIfPresent("222", bif);//2         
        BankAccount ba = (BankAccount) myAccts.get("222");
        System.out.println(ba.getBalance());
    }
}





















