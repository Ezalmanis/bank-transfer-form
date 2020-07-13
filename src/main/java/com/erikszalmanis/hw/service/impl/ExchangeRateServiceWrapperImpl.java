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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

//TODO, test dis
@Service
public class ExchangeRateServiceWrapperImpl implements ExchangeRateServiceWrapper {

    private final Logger logger = LoggerFactory.getLogger(ExchangeRateServiceWrapperImpl.class);
    private final RestTemplate restTemplate;
    private final DefaultExchangeRateProvider mapper;

    private final static String DEFAULT_FILE ="src/main/resources/DefaultExchangeRates.json";

    @Autowired
    ExchangeRateServiceWrapperImpl(final RestTemplate restTemplate, final DefaultExchangeRateProvider mapper){
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public ExchangeRate getExchangeRate() throws NoDefaultExchangeRateException {
        try {
            return getExchangeRateFromApi();
        } catch (final NoRatesFoundException e) {
            final ExchangeRate rates = getDefaultExchangeRate();
            logger.info(String.format("Fetched exchange rates for date: %s", rates.getDate()));
            logger.info("Fetched default exchange rates");
            return rates;
        }
    }

    @Cacheable("rates")
    public ExchangeRate getExchangeRateFromApi() throws NoRatesFoundException{
        final LocalDate today = LocalDate.now();
        final Optional<ExchangeRate> response = Optional.ofNullable(restTemplate.getForObject("https://api.exchangeratesapi.io/latest", ExchangeRate.class));
        final ExchangeRate rates = response.orElseThrow(NoRatesFoundException::new);
        logger.info(String.format("Exchange rates for date: %s", rates.getDate()));
        logger.info(String.format("Exchange rates are %s days old", today.compareTo(rates.getDate())));
        return rates;
    }

    private ExchangeRate getDefaultExchangeRate() throws NoDefaultExchangeRateException {
        try {
            return mapper.readStringFromFile(DEFAULT_FILE);
        }catch (final IOException e){
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
