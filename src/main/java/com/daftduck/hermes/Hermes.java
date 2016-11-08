package com.daftduck.hermes;

import com.daftduck.hermes.requests.StopPointArrivalsRequest;
import com.daftduck.hermes.requests.StopPointSearchRequest;
import com.daftduck.hermes.responses.StopPointArrivalsResponse;
import com.daftduck.hermes.responses.StopPointSearchResponse;
import com.daftduck.hermes.responses.models.stoppoint.arrivals.StopPointArrival;
import com.daftduck.hermes.responses.models.stoppoint.search.StopPointSearch;

import java.util.List;

public class Hermes {

    private final HttpTfLRequestExecutor executor;

    private final String appId;
    private final String appKey;

    public Hermes(String appId, String appKey) {
        this(appId, appKey, new HttpTfLRequestExecutor());
    }

    // Package protected constructor - used for testing
    Hermes(String appId, String appKey, HttpTfLRequestExecutor executor) {
        this.appId = appId;
        this.appKey = appKey;
        this.executor = executor;
    }

    public List<StopPointArrival> requestStopPointArrivals(String stopPointId) throws HermesException {
        StopPointArrivalsRequest request = new StopPointArrivalsRequest(appId, appKey, stopPointId);

        String response = executor.execute(request);

        return new StopPointArrivalsResponse(response).mapResponse();
    }

    public StopPointSearch requestStopPointSearch(String query, String modes) throws HermesException {
        StopPointSearchRequest request = new StopPointSearchRequest(appId, appKey, query).withModes(modes);

        String response = executor.execute(request);

        return new StopPointSearchResponse(response).mapResponse();
    }

}
