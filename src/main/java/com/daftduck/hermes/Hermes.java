package com.daftduck.hermes;

import com.daftduck.hermes.requests.StopPointArrivalsRequest;
import com.daftduck.hermes.requests.StopPointByIdRequest;
import com.daftduck.hermes.requests.StopPointSearchRequest;
import com.daftduck.hermes.responses.ResponseMapper;
import com.daftduck.hermes.responses.models.stoppoint.arrivals.StopPointArrival;
import com.daftduck.hermes.responses.models.stoppoint.byid.StopPoint;
import com.daftduck.hermes.responses.models.stoppoint.search.SearchResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class Hermes {

    private final String appId;
    private final String appKey;

    private final HttpTfLRequestExecutor executor;
    private final ResponseMapper mapper;

    public Hermes(String appId, String appKey) {
        this(appId, appKey, new HttpTfLRequestExecutor(), new ResponseMapper());
    }

    // Package protected constructor - used for testing
    Hermes(String appId, String appKey, HttpTfLRequestExecutor executor, ResponseMapper mapper) {
        this.appId = appId;
        this.appKey = appKey;
        this.executor = executor;
        this.mapper = mapper;
    }

    public List<StopPointArrival> requestStopPointArrivals(String stopPointId) throws HermesException {
        StopPointArrivalsRequest request = new StopPointArrivalsRequest(appId, appKey, stopPointId);
        String response = executor.execute(request);
        return mapper.mapResponse(response, new TypeReference<List<StopPointArrival>>() {});
    }

    public SearchResponse requestStopPointSearch(String query, String modes) throws HermesException {
        StopPointSearchRequest request = new StopPointSearchRequest(appId, appKey, query).withModes(modes);
        String response = executor.execute(request);
        return mapper.mapResponse(response, new TypeReference<SearchResponse>() {});
    }

    public StopPoint requestStopPointById(String stopPointId) throws HermesException {
        StopPointByIdRequest request = new StopPointByIdRequest(appId, appKey, stopPointId);
        String response = executor.execute(request);
        return mapper.mapResponse(response, new TypeReference<StopPoint>() {});
    }

}
