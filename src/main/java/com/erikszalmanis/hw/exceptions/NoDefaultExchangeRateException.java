package com.erikszalmanis.hw.exceptions;

public class NoDefaultExchangeRateException extends Exception {
    public NoDefaultExchangeRateException() {
        super("No default exchange rates found");
    }
}