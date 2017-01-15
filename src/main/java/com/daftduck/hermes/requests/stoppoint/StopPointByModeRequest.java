package com.daftduck.hermes.requests.stoppoint;

import com.daftduck.hermes.requests.TfLRequest;

public class StopPointByModeRequest implements TfLRequest {

    private final String appId;
    private final String appKey;
    private final String mode;

    public StopPointByModeRequest(String appId, String appKey, String mode) {
        this.appId = appId;
        this.appKey = appKey;
        this.mode = mode;
    }

    @Override
    public String getRequest() {
        return String.format("%s/StopPoint/Mode/%s?app_id=%s&app_key=%s", API_URL, mode, appId, appKey);
    }
}
