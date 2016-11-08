package com.daftduck.hermes.responses.models.stoppoint.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPointSearch {

    @JsonProperty("$type")
    private String type;
    private String query;
    private long total;
    private List<StopPointSearchMatch> matches;

    public String getType() {
        return type;
    }

    public String getQuery() {
        return query;
    }

    public long getTotal() {
        return total;
    }

    public List<StopPointSearchMatch> getMatches() {
        return matches;
    }

}
