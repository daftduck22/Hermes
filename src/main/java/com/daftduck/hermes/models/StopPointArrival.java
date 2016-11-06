package com.daftduck.hermes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPointArrival {

    @JsonProperty("$type")
    private String type;
    private String id;
    private String operationType;
    private String vehicleId;
    private String naptanId;
    private String stationName;

    private long timeToStation;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getNaptanId() {
        return naptanId;
    }

    public String getStationName() {
        return stationName;
    }

    public long getTimeToStation() {
        return timeToStation;
    }
}
