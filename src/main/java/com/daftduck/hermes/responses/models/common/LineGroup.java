package com.daftduck.hermes.responses.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineGroup {

    private String naptanIdReference;
    private String stationAtcoCode;
    private List<String> lineIdentifier;

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
