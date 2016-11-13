package com.daftduck.hermes.responses.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalProperties {

    @JsonProperty("$type")
    private String type;
    private String category;
    private String key;
    private String sourceSystemKey;
    private String value;

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String getKey() {
        return key;
    }

    public String getSourceSystemKey() {
        return sourceSystemKey;
    }

    public String getValue() {
        return value;
    }

}
