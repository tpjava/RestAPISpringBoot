package com.perrin.tony.controller.responses;

/**
 * Created by tonyperrin on 04/01/2014.
 */
public class CreatedResponse extends Response {
    private static final String STATUS = "201";

    public CreatedResponse(String s) {
        super(STATUS, s);
    }
}
