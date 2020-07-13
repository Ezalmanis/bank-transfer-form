package com.erikszalmanis.hw.util;

import com.erikszalmanis.hw.domain.objects.ExchangeRate;

import java.io.IOException;

//Todo, look into making this a better way, cant mock ObjectMapper properly.
public interface ObjectMapperWrapper {
    ExchangeRate readStringFromFile(String path) throws IOException;
}
