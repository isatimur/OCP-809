package com.isatimur.ocp.enthuware.interfaces_jav8;

import java.util.Locale;

interface Account {
    public default String getId() {
        return "0000";
    }
}

interface PremiumAccount extends Account {
    public String getId();
}

public class BankAccount implements PremiumAccount {
    public static void main(String[] args) {
        Account acct = new BankAccount();
        System.out.println(acct.getId());
    }

    @Override
    public String getId() {
        return null;
    }


}