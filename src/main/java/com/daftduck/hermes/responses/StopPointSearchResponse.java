package com.daftduck.hermes.responses;

import com.daftduck.hermes.HermesException;
import com.daftduck.hermes.responses.models.stoppoint.search.StopPointSearch;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class StopPointSearchResponse {

    private String jsonResponse;

    public StopPointSearchResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    public StopPointSearch mapResponse() throws HermesException {
        try {
            return new ObjectMapper().readValue(jsonResponse, new TypeReference<StopPointSearch>() {
            });
        } catch (IOException e) {
            throw new HermesException("Unable to map StopPointSearch response: " + jsonResponse, e);
        }
    }

}
