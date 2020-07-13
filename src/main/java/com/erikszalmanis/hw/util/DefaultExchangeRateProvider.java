package com.erikszalmanis.hw.util;

import com.erikszalmanis.hw.domain.objects.ExchangeRate;

import java.io.IOException;

public interface DefaultExchangeRateProvider {
    ExchangeRate readStringFromFile(String path) throws IOException;
}
