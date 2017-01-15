package com.daftduck.hermes;

import com.daftduck.hermes.requests.TfLRequest;
import com.daftduck.hermes.requests.stoppoint.StopPointArrivalsRequest;
import com.daftduck.hermes.requests.stoppoint.StopPointByIdRequest;
import com.daftduck.hermes.requests.stoppoint.StopPointCategoriesMetadataRequest;
import com.daftduck.hermes.requests.stoppoint.StopPointSearchRequest;
import com.daftduck.hermes.responses.ResponseMapper;
import com.daftduck.hermes.responses.models.stoppoint.arrivals.StopPointArrival;
import com.daftduck.hermes.responses.models.stoppoint.byid.StopPoint;
import com.daftduck.hermes.responses.models.stoppoint.metadata.StopPointCategory;
import com.daftduck.hermes.responses.models.stoppoint.search.SearchResponse;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class Hermes {

    private final String appId;
    private final String appKey;

    private final HttpTfLRequestExecutor requestExecutor;
    private final ResponseMapper mapper;

    public Hermes(String appId, String appKey) {
        this(appId, appKey, new HttpTfLRequestExecutor(), new ResponseMapper());
    }

    // Package protected constructor - used for testing
    Hermes(String appId, String appKey, HttpTfLRequestExecutor requestExecutor, ResponseMapper mapper) {
        this.appId = appId;
        this.appKey = appKey;
        this.requestExecutor = requestExecutor;
        this.mapper = mapper;
    }

    /* Public Methods */

    public List<StopPointCategory> requestStopPointCategoriesMetadata() throws HermesException {
        return execute(new StopPointCategoriesMetadataRequest(appId, appKey), new TypeReference<List<StopPointCategory>>() {});
    }

    public List<StopPointArrival> requestStopPointArrivals(String stopPointId) throws HermesException {
        return execute(new StopPointArrivalsRequest(appId, appKey, stopPointId), new TypeReference<List<StopPointArrival>>() {});
    }

    public SearchResponse requestStopPointSearch(String query, String modes) throws HermesException {
        return execute(new StopPointSearchRequest(appId, appKey, query).withModes(modes), new TypeReference<SearchResponse>() {});
    }

    public StopPoint requestStopPointById(String stopPointId) throws HermesException {
        return execute(new StopPointByIdRequest(appId, appKey, stopPointId), new TypeReference<StopPoint>() {});
    }

    /* Helper Methods */

    private <T> T execute(TfLRequest request, TypeReference<T> responseType) throws HermesException {
        String response = requestExecutor.execute(request);
        return mapper.mapResponse(response, responseType);
    }

}
