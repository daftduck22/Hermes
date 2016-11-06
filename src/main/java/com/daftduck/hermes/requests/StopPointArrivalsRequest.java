package com.daftduck.hermes.requests;

public class StopPointArrivalsRequest implements TfLRequest {

    private final String appId;
    private final String appKey;
    private String stopPointId;

    public StopPointArrivalsRequest(String appId, String appKey, String stopPointId) {
        this.appId = appId;
        this.appKey = appKey;
        this.stopPointId = stopPointId;
    }

    @Override
    public String getRequest() {
        return String.format("%s/StopPoint/%s/Arrivals?app_id=%s&app_key=%s", API_URL, stopPointId, appId, appKey);
    }

}
