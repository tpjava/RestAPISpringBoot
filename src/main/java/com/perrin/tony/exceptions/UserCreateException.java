package com.perrin.tony.exceptions;

/**
 * Created by tonyperrin on 04/01/2014.
 */
//@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Error creating user.")
public class UserCreateException extends RuntimeException {
    public UserCreateException(String message) {
        super(message);
    }
}
