package com.zloebok.ordermealservice.Errors;

public class SaveOrderException extends Exception {

    public SaveOrderException(String errorMessage) {
        super(errorMessage);
    }
}
