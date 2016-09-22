package main.com.isatimur.ocp.localization;

import java.util.ListResourceBundle;

/**
 * Created by Isa Timur on 6/27/16.
 */
public class IndianArtLabelsBundle extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][] {
            {"total_bookings", "Total Bookings"},
            {"when", "When"},
            {"price", "Price"},
            {"book_now", "Book Now"},
            {"sample_art", "flag_fish.png"},
        };
    }
}