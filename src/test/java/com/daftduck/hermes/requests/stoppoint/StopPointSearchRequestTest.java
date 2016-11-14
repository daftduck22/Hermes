package com.daftduck.hermes.requests.stoppoint;

import com.daftduck.hermes.requests.TfLRequest;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StopPointSearchRequestTest {

    @Test
    public void shouldBuildRequestForRequiredFields() {
        TfLRequest request = new StopPointSearchRequest("app-id", "app-key", "query");

        assertThat(request.getRequest()).isEqualTo("https://api.tfl.gov.uk/StopPoint/Search/query?app_id=app-id&app_key=app-key");
    }

    @Test
    public void shouldBuildRequestWithOptionalFields() {
        StopPointSearchRequest searchRequest = new StopPointSearchRequest("app-id", "app-key", "query");
        TfLRequest request = searchRequest.withModes("dlr");

        assertThat(request).isEqualTo(searchRequest);
        assertThat(request.getRequest()).isEqualTo("https://api.tfl.gov.uk/StopPoint/Search/query?app_id=app-id&app_key=app-key&modes=dlr");
    }

}