package com.erikszalmanis.hw.util.impl;

import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.util.ObjectMapperWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
//Todo, look into generics, and ow to replace this
public class ObjectMapperWrapperImpl implements ObjectMapperWrapper {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ExchangeRate readStringFromFile(final String path) throws IOException {
        return mapper.readValue(new File(path), ExchangeRate.class);

    }
}
