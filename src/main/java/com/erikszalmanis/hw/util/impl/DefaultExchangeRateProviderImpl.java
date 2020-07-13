package com.erikszalmanis.hw.util.impl;

import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.util.DefaultExchangeRateProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
//Todo, will do for now, might look into smth more fancy later
public class DefaultExchangeRateProviderImpl implements DefaultExchangeRateProvider {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ExchangeRate readStringFromFile(final String path) throws IOException {
        return mapper.readValue(new File(path), ExchangeRate.class);

    }
}
