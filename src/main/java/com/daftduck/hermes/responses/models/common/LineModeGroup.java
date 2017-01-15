package com.daftduck.hermes.responses.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineModeGroup {

    private String modeName;
    private List<String> lineIdentifier;

    public String getModeName() {
        return modeName;
    }

    public List<String> getLineIdentifier() {
        return lineIdentifier;
    }
}
