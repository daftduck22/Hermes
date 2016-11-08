package com.daftduck.hermes.requests;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class StopPointSearchRequest implements TfLRequest {

    private final String appId;
    private final String appKey;
    private final String query;
    private String modes;

    public StopPointSearchRequest(String appId, String appKey, String query) {
        this.appId = appId;
        this.appKey = appKey;
        this.query = query;
    }

    public StopPointSearchRequest withModes(String modes) {
        this.modes = modes;
        return this;
    }

    @Override
    public String getRequest() {
        String request = String.format("%s/StopPoint/Search/%s?app_id=%s&app_key=%s", API_URL, query, appId, appKey);
        if (isNotBlank(modes)) {
            request = request.concat("&modes=" + modes);
        }
        return request;
    }
}
