package com.fullstack.gvozdenbank.exceptions;

public class UnauthorisedUserException extends Exception{
    public UnauthorisedUserException(String errorMessage) {
        super(errorMessage);
    }
}
