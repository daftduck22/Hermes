package com.daftduck.hermes;

import com.daftduck.hermes.requests.TfLRequest;

import java.io.IOException;

import static org.apache.http.client.fluent.Request.Get;

public class HttpTfLRequestExecutor {

    public String execute(TfLRequest request) throws Exception {
        try {
            return Get(request.getRequest()).execute().returnContent().toString();
        } catch (IOException e) {
            throw new Exception("Unable to execute request for " + request.getRequest(), e);
        }
    }

}
