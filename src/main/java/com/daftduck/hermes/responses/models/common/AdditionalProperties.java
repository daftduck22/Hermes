package com.daftduck.hermes.responses.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalProperties {

    private String category;
    private String key;
    private String sourceSystemKey;
    private String value;

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
