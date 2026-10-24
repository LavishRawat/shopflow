package com.shopflow.practice;

import java.util.*;

/**
 * Saturday, part 1: Collections (List, Set, Map).
 * Type the example inside main, run it, then change one thing and run again.
 */
public class CollectionsLab {

    public static void main(String[] args) {
        try {
            int[] stock = {5, 3};
            System.out.println(stock[5]);
            System.out.println("Inside try, after the problem");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops: " + e.getMessage());
        } finally {
            System.out.println("finally always runs");
        }
        System.out.println("Program keeps going");

    }
}
