package com.shopflow.practice;

import java.util.*;

/**
 * Saturday, part 3: Records, lambdas and Optional.
 * Type the example inside main, run it, then change one thing and run again.
 */
public class ModernJavaLab {
    record Product(String name, int price) {};

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product("Tea", 20),
                new Product("Milk", 30),
                new Product("Bread", 15)));

//        // 1. Do something with each item
//        products.forEach(p -> System.out.println(p.name()));
//
//        // 2. Sort by price, cheapest first
//        products.sort(Comparator.comparing(p -> p.price()));
//        System.out.println(products);
//
//        // 3. Remove items that match a rule
//        products.removeIf(p -> p.price() < 18);
//        System.out.println(products);


        List<Product> menu = List.of(
                new Product("Tea", 20),
                new Product("Milk", 30),
                new Product("Bread", 15),
                new Product("Coffee", 40),
                new Product("Biscuit", 10));

        List<String> priceyNames = menu.stream()
                .filter(p -> p.price <25)
                .map(p -> p.name());


        Integer total = menu.stream()
                .filter(p -> p.price > 15)
                .count();

        Optional<Product> mostExpensive = menu.stream()
                .max(Comparator.comparing(p -> p.price()));
        System.out.println(mostExpensive.map(p -> p.name()).orElse("Menu is empty"));   // Coffee
    }
}
