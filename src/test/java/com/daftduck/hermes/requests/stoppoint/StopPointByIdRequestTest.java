package com.daftduck.hermes.requests.stoppoint;

import com.daftduck.hermes.requests.TfLRequest;
import com.daftduck.hermes.requests.stoppoint.StopPointByIdRequest;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StopPointByIdRequestTest {

    @Test
    public void shouldBuildRequestForRequiredFields() {
        TfLRequest request = new StopPointByIdRequest("app-id", "app-key", "stop-point-id");

        assertThat(request.getRequest()).isEqualTo("https://api.tfl.gov.uk/StopPoint/stop-point-id?app_id=app-id&app_key=app-key");
    }

}