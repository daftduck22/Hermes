package com.daftduck.hermes.responses.models.stoppoint.byid;

import com.daftduck.hermes.responses.models.common.AdditionalProperties;
import com.daftduck.hermes.responses.models.common.Identifier;
import com.daftduck.hermes.responses.models.common.LineGroup;
import com.daftduck.hermes.responses.models.common.LineModeGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPoint {

    @JsonProperty("$type")
    private String type;
    private String naptanId;
    private String indicator;
    private String stopLetter;
    private List<String> modes;
    private String icsCode;
    private String smsCode;
    private String stopType;
    private String stationNaptan;
    private List<Identifier> lines;
    private List<LineGroup> lineGroup;
    private List<LineModeGroup> lineModeGroups;
    private boolean status;
    private String id;
    private String commonName;
    private String placeType;
    private List<AdditionalProperties> additionalProperties;
    private List<StopPoint> children;
    private double lat;
    private double lon;

    public String getType() {
        return type;
    }

    public String getNaptanId() {
        return naptanId;
    }

    public String getIndicator() {
        return indicator;
    }

    public String getStopLetter() {
        return stopLetter;
    }

    public List<String> getModes() {
        return modes;
    }

    public String getIcsCode() {
        return icsCode;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public String getStopType() {
        return stopType;
    }

    public String getStationNaptan() {
        return stationNaptan;
    }

    public List<Identifier> getLines() {
        return lines;
    }

    public List<LineGroup> getLineGroup() {
        return lineGroup;
    }

    public List<LineModeGroup> getLineModeGroups() {
        return lineModeGroups;
    }

    public boolean getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getPlaceType() {
        return placeType;
    }

    public List<AdditionalProperties> getAdditionalProperties() {
        return additionalProperties;
    }

    public List<StopPoint> getChildren() {
        return children;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
