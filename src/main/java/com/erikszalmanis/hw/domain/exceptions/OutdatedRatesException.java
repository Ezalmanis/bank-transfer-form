package com.erikszalmanis.hw.domain.exceptions;

public class OutdatedRatesException extends Exception {
    public OutdatedRatesException(final Double expected, final Double actual) {
        super("Exception thrown while fetching exchange rates");
    }
}