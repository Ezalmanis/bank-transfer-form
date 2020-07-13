package com.erikszalmanis.hw.service;

import com.erikszalmanis.hw.domain.exceptions.NoRatesFoundException;
import com.erikszalmanis.hw.domain.objects.ExchangeRate;

public interface ExchangeRateServiceWrapper {
    ExchangeRate getExchangeRate() throws NoRatesFoundException;
}
