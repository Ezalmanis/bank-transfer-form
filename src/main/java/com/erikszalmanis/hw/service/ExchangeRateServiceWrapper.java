package com.erikszalmanis.hw.service;

import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.exceptions.NoDefaultExchangeRateException;
import com.erikszalmanis.hw.exceptions.NoRatesFoundException;

public interface ExchangeRateServiceWrapper {

    ExchangeRate getExchangeRates() throws NoRatesFoundException, NoDefaultExchangeRateException;
}
