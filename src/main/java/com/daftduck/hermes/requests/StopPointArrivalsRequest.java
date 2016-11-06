package com.daftduck.hermes.requests;

public class StopPointArrivalsRequest {

    private final String appId;
    private final String appKey;
    private String stopPointId;

    public StopPointArrivalsRequest(String appId, String appKey, String stopPointId) {
        this.appId = appId;
        this.appKey = appKey;
        this.stopPointId = stopPointId;
    }

    public String getRequest() {
        return String.format("https://api.tfl.gov.uk/StopPoint/%s/Arrivals?app_id=%s&app_key=%s", stopPointId, appId, appKey);
    }

}
