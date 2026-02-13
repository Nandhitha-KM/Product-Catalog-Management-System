package com.wipro.product.util;

public class InvalidInputException extends Exception {

    public InvalidInputException() {
        super();
    }

    @Override
    public String toString() {
        return "Invalid Input";
    }
}
