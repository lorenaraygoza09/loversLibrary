package com.org.demo.exception;

public class BadRequestException extends RuntimeException{
    //for username, email and reviews duplicities
    public BadRequestException(String message){
        super(message);
    }
}
