package com.daftduck.hermes.responses.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Identifier {

    private String id;
    private String name;
    private String uri;
    private String type;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public String getType() {
        return type;
    }
}
