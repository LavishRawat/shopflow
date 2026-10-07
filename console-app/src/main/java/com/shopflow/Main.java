package com.shopflow;

import java.util.Scanner;
import java.math.BigDecimal;

/**
 * Starting point of the ShopFlow console app.
 * Follow EXERCISES.md, beginning with Step 1.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        System.out.println("Welcome to ShopFlow!");

        while ( isRunning) {
            System.out.println();
            System.out.println("=== ShopFlow ===");
            System.out.println("1. List products");
            System.out.println("2. Add product");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1 -> {
                    Product laptop = new Product(1, "Laptop", new BigDecimal("55000.00"), 10);
                    Product mouse = new Product(2, "Mouse", new BigDecimal("1500.00"), 10);
                    Product keyboard = new Product(3, "Keyboard", new BigDecimal("12000.00"), 10);
                    System.out.println(laptop);
                    System.out.println(mouse);
                    System.out.println(keyboard);
                }
                case 2 -> System.out.println("Coming soon");
                case 0 -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
