package com.fullstack.gvozdenbank.exceptions;

public class InsuficientBalanceException extends Exception {
    public InsuficientBalanceException(String errorMessage) {
        super(errorMessage);
    }
}