package org.akaichi.springmvc;

import java.util.Map;

public class ShopCategory {
    public enum Categories {
        Sport,
        Pharmacy,
        Convenience,
        Bookselling,
        Department,
        Bakery;
    }

    public static String getCategory(int category) {
        return String.valueOf(Categories.values()[category]);
    }
}



