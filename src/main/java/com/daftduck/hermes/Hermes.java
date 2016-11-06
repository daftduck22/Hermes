package com.daftduck.hermes;

import com.daftduck.hermes.models.StopPointArrival;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.List;

public class Hermes {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String appId;
    private final String appKey;

    public Hermes(String AppId, String AppKey) {
        appId = AppId;
        appKey = AppKey;
    }

    public List<StopPointArrival> requestStopPointArrivals(String stopPointId) {
        String url = String.format("https://api.tfl.gov.uk/StopPoint/%s/Arrivals?app_id=%s&app_key=%s", stopPointId, appId, appKey);

        try {
            String response = Request.Get(url).execute().returnContent().toString();
            return OBJECT_MAPPER.readValue(response, new TypeReference<List<StopPointArrival>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
