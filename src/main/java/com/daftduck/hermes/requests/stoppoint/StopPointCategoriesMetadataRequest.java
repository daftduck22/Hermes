package com.daftduck.hermes.requests.stoppoint;

import com.daftduck.hermes.requests.TfLRequest;

public class StopPointCategoriesMetadataRequest implements TfLRequest {

    private final String appId;
    private final String appKey;

    public StopPointCategoriesMetadataRequest(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
    }

    @Override
    public String getRequest() {
        return String.format("%s/StopPoint/Meta/categories?app_id=%s&app_key=%s", API_URL, appId, appKey);
    }
}
