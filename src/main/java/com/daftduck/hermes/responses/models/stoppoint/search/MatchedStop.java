package com.daftduck.hermes.responses.models.stoppoint.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchedStop {

    @JsonProperty("$type")
    private String type;
    private String icsId;
    private List<String> modes;
    private String id;
    private String name;
    private double lat;
    private double lon;

    public String getType() {
        return type;
    }

    public String getIcsId() {
        return icsId;
    }

    public List<String> getModes() {
        return modes;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
