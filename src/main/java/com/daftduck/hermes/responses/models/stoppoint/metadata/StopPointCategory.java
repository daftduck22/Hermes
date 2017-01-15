package com.daftduck.hermes.responses.models.stoppoint.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPointCategory {

    private String category;
    private List<String> availableKeys;

    public String getCategory() {
        return category;
    }

    public List<String> getAvailableKeys() {
        return availableKeys;
    }

}
