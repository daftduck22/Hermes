package com.daftduck.hermes.responses.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineGroup {

    @JsonProperty("$type")
    private String type;
    private String naptanIdReference;
    private String stationAtcoCode;
    private List<String> lineIdentifier;

    public String getType() {
        return type;
    }

    public String getNaptanIdReference() {
        return naptanIdReference;
    }

    public String getStationAtcoCode() {
        return stationAtcoCode;
    }

    public List<String> getLineIdentifier() {
        return lineIdentifier;
    }

}
