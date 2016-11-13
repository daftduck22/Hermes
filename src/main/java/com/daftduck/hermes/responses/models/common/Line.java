package com.daftduck.hermes.responses.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Line {

    @JsonProperty("$type")
    private String apiType;
    private String id;
    private String name;
    private String uri;
    private String type;

    public String getApiType() {
        return apiType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public String getType() {
        return type;
    }
}
