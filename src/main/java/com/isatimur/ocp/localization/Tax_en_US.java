package com.isatimur.ocp.localization;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Isa Timur on 8/16/16.
 */
public class Tax_en_US extends ListResourceBundle {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("main.com.isatimur.ocp.localization.Tax");
        System.out.println(rb.getObject("tax"));
    }

    @Override protected Object[][] getContents() {
        return new Object[][] {
            {"tax", new USTaxCode()}
        };
    }
}

class USTaxCode {
    @Override public String toString() {
        return "I'm an american tax!";
    }
}