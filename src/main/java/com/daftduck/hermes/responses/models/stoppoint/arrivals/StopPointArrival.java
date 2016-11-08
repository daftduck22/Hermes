package com.daftduck.hermes.responses.models.stoppoint.arrivals;

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
    private String lineId;
    private String lineName;
    private String platformName;
    private String direction;
    private String bearing;
    private String destinationNaptanId;
    private String destinationName;
    private String timestamp;
    private long timeToStation;
    private String currentLocation;
    private String towards;
    private String expectedArrival;
    private String timeToLive;
    private String modeName;

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

    public String getLineId() {
        return lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getDirection() {
        return direction;
    }

    public String getBearing() {
        return bearing;
    }

    public String getDestinationNaptanId() {
        return destinationNaptanId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public long getTimeToStation() {
        return timeToStation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getTowards() {
        return towards;
    }

    public String getExpectedArrival() {
        return expectedArrival;
    }

    public String getTimeToLive() {
        return timeToLive;
    }

    public String getModeName() {
        return modeName;
    }

}
