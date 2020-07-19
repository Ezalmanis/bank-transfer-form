package com.erikszalmanis.hw.service.impl;

import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.exceptions.NoDefaultExchangeRateException;
import com.erikszalmanis.hw.exceptions.NoRatesFoundException;
import com.erikszalmanis.hw.service.ExchangeRateServiceWrapper;
import com.erikszalmanis.hw.util.DefaultExchangeRateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

//TODO, test dis
@Service
public class ExchangeRateServiceWrapperImpl implements ExchangeRateServiceWrapper {

    private final static String DEFAULT_FILE = "src/main/resources/DefaultExchangeRates.json";
    private final Logger logger = LoggerFactory.getLogger(ExchangeRateServiceWrapperImpl.class);
    private final RestTemplate restTemplate;
    private final DefaultExchangeRateProvider mapper;

    @Autowired
    ExchangeRateServiceWrapperImpl(final RestTemplate restTemplate, final DefaultExchangeRateProvider mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    //TODO, add get exchange rate for specific date.
    @Override
    public ExchangeRate getExchangeRates() throws NoDefaultExchangeRateException {
        final LocalDate today = LocalDate.now();
        try {
            final ExchangeRate rates =  getExchangeRateFromApi();
            logger.info(("Exchange rates for date: {}"), rates.getDate());
            logger.info(("Exchange rates are {} days old"), today.compareTo(rates.getDate()));
            return rates;
        } catch (final NoRatesFoundException e) {
            final ExchangeRate rates = getDefaultExchangeRates();
            logger.warn("Fetching default exchange rates");
            logger.info(("Fetched exchange rates for date: {}"), rates.getDate());
            return rates;
        }
    }


    @Cacheable("rates")
    public ExchangeRate getExchangeRateFromApi() throws NoRatesFoundException {
        final ResponseEntity<ExchangeRate> response = restTemplate.getForEntity("https://api.exchangeratesapi.io/latest", ExchangeRate.class);
        if(response.getStatusCode().is2xxSuccessful() && response.hasBody()){
            return Optional.ofNullable(response.getBody()).orElseThrow(NoRatesFoundException::new);
        }else throw new NoRatesFoundException();
    }

    private ExchangeRate getDefaultExchangeRates() throws NoDefaultExchangeRateException {
        try {
            return mapper.readStringFromFile(DEFAULT_FILE);
        } catch (final IOException e) {
            throw new NoDefaultExchangeRateException();
        }
    }

    @Configuration
    public static class Config {
        @Bean
        public RestTemplate restTemplate(final RestTemplateBuilder builder) {
            return builder.build();
        }
    }

}
