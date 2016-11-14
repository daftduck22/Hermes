package com.daftduck.hermes.requests.stoppoint;

import com.daftduck.hermes.requests.TfLRequest;

public class StopPointByIdRequest implements TfLRequest {

    private final String appId;
    private final String appKey;
    private final String stopPointId;

    public StopPointByIdRequest(String appId, String appKey, String stopPointId) {
        this.appId = appId;
        this.appKey = appKey;
        this.stopPointId = stopPointId;
    }

    @Override
    public String getRequest() {
        return String.format("%s/StopPoint/%s?app_id=%s&app_key=%s", API_URL, stopPointId, appId, appKey);
    }
}
