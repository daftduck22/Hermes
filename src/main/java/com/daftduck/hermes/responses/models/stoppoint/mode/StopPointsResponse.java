package com.daftduck.hermes.responses.models.stoppoint.mode;

import com.daftduck.hermes.responses.models.stoppoint.byid.StopPoint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPointsResponse {

    private List<StopPoint> stopPoints;
    private long pageSize;
    private long total;
    private long page;

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getTotal() {
        return total;
    }

    public long getPage() {
        return page;
    }

}
