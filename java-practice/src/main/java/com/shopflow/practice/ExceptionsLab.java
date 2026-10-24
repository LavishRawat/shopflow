package com.shopflow.practice;

import java.util.*;

/**
 * Saturday, part 2: Exceptions (try, catch, finally).
 * Type the example inside main, run it, then change one thing and run again.
 */
public class ExceptionsLab {

    static void buy(String item, int stock) throws OutOfStockException {
        if (stock == 0) {
            throw new OutOfStockException(item + " is out of stock");
        }
        System.out.println("Bought " + item);
    }

    public static void main(String[] args) {
        try {
            buy("tea", 5);
            buy("milk", 0);
            buy("bread", 2);
        } catch (OutOfStockException e) {
            System.out.println("Sorry: " + e.getMessage());
        }
    }
}
