package com.daftduck.hermes.responses;

import com.daftduck.hermes.responses.models.StopPointArrival;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class StopPointArrivalsResponse {

    private String jsonResponse;

    public StopPointArrivalsResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    public List<StopPointArrival> mapResponse() throws Exception {
        try {
            return new ObjectMapper().readValue(jsonResponse, new TypeReference<List<StopPointArrival>>() {
            });
        } catch (IOException e) {
            throw new Exception("Unable to map StopPointArrival response: " + jsonResponse, e);
        }
    }

}
