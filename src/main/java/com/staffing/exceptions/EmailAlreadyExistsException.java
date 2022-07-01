package com.staffing.exceptions;

public class EmailAlreadyExistsException extends Exception{

    public EmailAlreadyExistsException(String email_already_exists) {
        super("Email already exists");
    }
}
