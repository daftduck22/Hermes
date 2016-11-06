package com.daftduck.hermes;

import com.daftduck.hermes.requests.TfLRequest;

import static org.apache.http.client.fluent.Request.Get;

public class HttpTfLRequestExecutor {

    public String execute(TfLRequest request) throws HermesException {
        try {
            return Get(request.getRequest()).execute().returnContent().toString();
        } catch (Exception e) {
            throw new HermesException("Unable to execute request for " + request.getRequest(), e);
        }
    }

}
