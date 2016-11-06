package com.daftduck.hermes;

import com.daftduck.hermes.requests.StopPointArrivalsRequest;
import com.daftduck.hermes.responses.StopPointArrivalsResponse;
import com.daftduck.hermes.responses.models.StopPointArrival;

import java.util.List;

public class Hermes {

    private final HttpTfLRequestExecutor executor = new HttpTfLRequestExecutor();

    private final String appId;
    private final String appKey;

    public Hermes(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
    }

    public List<StopPointArrival> requestStopPointArrivals(String stopPointId) throws HermesException {
        StopPointArrivalsRequest request = new StopPointArrivalsRequest(appId, appKey, stopPointId);

        String response = executor.execute(request);

        return new StopPointArrivalsResponse(response).mapResponse();
    }

}
