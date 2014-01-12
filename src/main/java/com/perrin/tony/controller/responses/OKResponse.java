package com.perrin.tony.controller.responses;

/**
 * Created by tonyperrin on 04/01/2014.
 */
public class OKResponse extends Response {
    private static final String STATUS = "200";

    public OKResponse(String s) {
        super(STATUS, s);
    }
}
