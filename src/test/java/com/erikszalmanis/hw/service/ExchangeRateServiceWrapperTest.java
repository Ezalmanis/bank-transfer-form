package com.erikszalmanis.hw.service;

import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.exceptions.NoDefaultExchangeRateException;
import com.erikszalmanis.hw.service.impl.ExchangeRateServiceWrapperImpl;
import com.erikszalmanis.hw.util.impl.DefaultExchangeRateProviderImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeRateServiceWrapperTest {

    private final Logger logger = LoggerFactory.getLogger(ExchangeRateServiceWrapperImpl.class);
    @InjectMocks
    ExchangeRateServiceWrapperImpl serviceWrapper;
    @Mock
    RestTemplate template;
    @Mock
    DefaultExchangeRateProviderImpl mapper;
    ObjectMapper objectMapper = new ObjectMapper();

    private final static String DEFAULT_FILE ="src/main/resources/DefaultExchangeRates.json";

    @Test
    void getDefaultExchangeRate() throws NoDefaultExchangeRateException, IOException {
        final ExchangeRate expectedRate = objectMapper.readValue(new File(DEFAULT_FILE), ExchangeRate.class);

        when(template.getForObject(any(String.class), eq(ExchangeRate.class))).thenReturn(null);
        when(mapper.readStringFromFile(anyString())).thenReturn(expectedRate);

        final ExchangeRate actualRate = serviceWrapper.getExchangeRate();
        Assertions.assertEquals(expectedRate, actualRate);

    }
    @Test
    void getCurrentExchangeRate() throws IOException, NoDefaultExchangeRateException {
        final ExchangeRate expectedRate = objectMapper.readValue(new File(DEFAULT_FILE), ExchangeRate.class);
        when(template.getForObject(any(String.class), eq(ExchangeRate.class))).thenReturn(expectedRate);
        final ExchangeRate actualRate = serviceWrapper.getExchangeRate();
        Assertions.assertEquals(expectedRate, actualRate);

    }

    @Test
    void failOnDefaultExchangeRate() throws IOException {
        when(template.getForObject(anyString(), eq(ExchangeRate.class))).thenReturn(null);
        when(mapper.readStringFromFile(anyString())).thenThrow(IOException.class);
        Assertions.assertThrows(NoDefaultExchangeRateException.class, ()->serviceWrapper.getExchangeRate());

    }
}
