package com.example.productinformation.exception;

public class NoSuchFurnitureException extends RuntimeException{
    private static final long serialVersionUID = 6387382920586717250L;
    public NoSuchFurnitureException(String message){
        super(message);
    }
}
