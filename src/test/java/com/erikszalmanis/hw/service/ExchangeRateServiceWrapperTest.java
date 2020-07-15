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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeRateServiceWrapperTest {

    private final static String DEFAULT_FILE = "src/main/resources/DefaultExchangeRates.json";
    private final Logger logger = LoggerFactory.getLogger(ExchangeRateServiceWrapperImpl.class);
    @InjectMocks
    ExchangeRateServiceWrapperImpl serviceWrapper;
    @Mock
    RestTemplate template;
    @Mock
    DefaultExchangeRateProviderImpl mapper;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getDefaultExchangeRate() throws NoDefaultExchangeRateException, IOException {
        final ExchangeRate expectedRate = objectMapper.readValue(new File(DEFAULT_FILE), ExchangeRate.class);
        final ResponseEntity<ExchangeRate> entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        when(template.getForEntity(any(String.class), eq(ExchangeRate.class))).thenReturn(entity);
        when(mapper.readStringFromFile(anyString())).thenReturn(expectedRate);

        final ExchangeRate actualRate = serviceWrapper.getExchangeRates();
        Assertions.assertEquals(expectedRate, actualRate);

    }

    @Test
    void getCurrentExchangeRate() throws IOException, NoDefaultExchangeRateException {
        final ExchangeRate expectedRate = objectMapper.readValue(new File(DEFAULT_FILE), ExchangeRate.class);
        final ResponseEntity<ExchangeRate> entity = new ResponseEntity<>(expectedRate, HttpStatus.OK);
        when(template.getForEntity(any(String.class), eq(ExchangeRate.class))).thenReturn(entity);
        final ExchangeRate actualRate = serviceWrapper.getExchangeRates();
        Assertions.assertEquals(expectedRate, actualRate);

    }

    @Test
    void failOnDefaultExchangeRate() throws IOException {
        final ResponseEntity<ExchangeRate> entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        when(template.getForEntity(anyString(), eq(ExchangeRate.class))).thenReturn(entity);
        when(mapper.readStringFromFile(anyString())).thenThrow(IOException.class);
        Assertions.assertThrows(NoDefaultExchangeRateException.class, () -> serviceWrapper.getExchangeRates());

    }
}
