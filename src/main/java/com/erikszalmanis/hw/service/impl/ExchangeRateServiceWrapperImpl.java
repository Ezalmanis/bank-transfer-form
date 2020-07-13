package com.erikszalmanis.hw.service.impl;

import com.erikszalmanis.hw.domain.exceptions.NoRatesFoundException;
import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.service.ExchangeRateServiceWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

//TODO, test dis
@Service
public class ExchangeRateServiceWrapperImpl implements ExchangeRateServiceWrapper {

    private final Logger logger = LoggerFactory.getLogger(ExchangeRateServiceWrapperImpl.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ExchangeRate getExchangeRate() {
        final LocalDate today = LocalDate.now();
        final Optional<ExchangeRate> response = Optional.ofNullable(restTemplate.getForObject("https://api.exchangeratesapi.io/latest", ExchangeRate.class));
        try {
            final ExchangeRate rates = response.orElseThrow(NoRatesFoundException::new);
            logger.info(String.format("Fetched exchange rates for date:%s", rates.getDate()));
            logger.info(String.format("Fetched exchange rates are %s days old", today.compareTo(rates.getDate())));
            return rates;
        } catch (final NoRatesFoundException e) {
            final ExchangeRate rates = getDefaultExchangeRate();
            logger.info(String.format("Fetched exchange rates for date:%s", rates.getDate()));
            logger.info("Fetched default exchange rates");
            return rates;
        }
    }

    private ExchangeRate getDefaultExchangeRate() {
        ExchangeRate rate;
        final String fileName = "resources/DefaultExchangeRates.json";
        final ObjectMapper mapper = new ObjectMapper();
        try {
            rate = mapper.readValue(new File("src/main/resources/DefaultExchangeRates.json"), ExchangeRate.class);
        } catch (final IOException e) {
            rate = new ExchangeRate();
        }
        return rate;
    }

}
