package com.shopflow.practice;

public class OutOfStockException extends Exception{

    public OutOfStockException(String message) {
        super(message);
    }
}
