package com.daftduck.hermes;

import com.daftduck.hermes.requests.StopPointArrivalsRequest;
import com.daftduck.hermes.responses.StopPointArrivalsResponse;
import com.daftduck.hermes.responses.models.StopPointArrival;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.List;

public class Hermes {

    private final String appId;
    private final String appKey;

    public Hermes(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
    }

    public List<StopPointArrival> requestStopPointArrivals(String stopPointId) throws Exception {
        StopPointArrivalsRequest request = new StopPointArrivalsRequest(appId, appKey, stopPointId);

        String response = executeRequest(request);

        return new StopPointArrivalsResponse(response).mapResponse();
    }

    private String executeRequest(StopPointArrivalsRequest request) throws Exception {
        try {
            return Request.Get(request.getRequest()).execute().returnContent().toString();
        } catch (IOException e) {
            throw new Exception("Unable to execute request for " + request.getRequest(), e);
        }
    }

}
