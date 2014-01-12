package com.perrin.tony.controller.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by tonyperrin on 04/01/2014.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="400 error.")
public class BadRequestResponse extends Response {
    private static final String STATUS = "400";

    public BadRequestResponse(String s) {
        super(STATUS, s);
    }
}
