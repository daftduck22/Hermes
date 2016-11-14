package com.daftduck.hermes.responses.models.stoppoint.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPointCategory {

    @JsonProperty("$type")
    private String type;
    private String category;
    private List<String> availableKeys;

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getAvailableKeys() {
        return availableKeys;
    }

}
