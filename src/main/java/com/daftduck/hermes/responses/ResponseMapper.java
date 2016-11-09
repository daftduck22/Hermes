package com.daftduck.hermes.responses;

import com.daftduck.hermes.HermesException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.fasterxml.jackson.databind.type.TypeFactory.rawClass;
import static java.lang.String.format;

public class ResponseMapper {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T mapResponse(String jsonResponse, TypeReference<T> responseType) throws HermesException {
        try {
            return objectMapper.readValue(jsonResponse, responseType);
        } catch (IOException e) {
            throw new HermesException(format("Unable to map response to %s: %s", rawClass(responseType.getType()), jsonResponse), e);
        }
    }

}
