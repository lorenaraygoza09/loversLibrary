package com.org.demo.exception;

public class ResourceNotFoundException extends RuntimeException{
   //exception when something doesn't exist
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
