package com.daftduck.hermes.responses.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineModeGroup {

    @JsonProperty("$type")
    private String type;
    private String modeName;
    private List<String> lineIdentifier;

    public String getType() {
        return type;
    }

    public String getModeName() {
        return modeName;
    }

    public List<String> getLineIdentifier() {
        return lineIdentifier;
    }
}
