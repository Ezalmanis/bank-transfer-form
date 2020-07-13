package com.erikszalmanis.hw.exceptions;

public class TransferAmountDiscrepancyException extends Exception {
    public TransferAmountDiscrepancyException(final Double expected, final Double actual) {
        super(String.format("Amount to transfer is incorrect, provided: %s, expected: %s", actual, expected));

    }
}
