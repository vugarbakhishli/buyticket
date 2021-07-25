package com.bakhishli.msaccount.exception;

public class AccountNotFoundException extends RuntimeException{
    public static final String MESSAGE = "Account not found: [%s]";

    public AccountNotFoundException(String id){
        super(String.format(MESSAGE, id));
    }
}
