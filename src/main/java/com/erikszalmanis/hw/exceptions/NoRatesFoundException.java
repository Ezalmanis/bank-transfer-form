package com.erikszalmanis.hw.exceptions;


public class NoRatesFoundException extends Exception {
    public NoRatesFoundException() {
        super("Exception thrown while fetching exchange rates");
    }
}
