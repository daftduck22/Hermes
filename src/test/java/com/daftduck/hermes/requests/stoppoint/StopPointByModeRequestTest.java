package com.daftduck.hermes.requests.stoppoint;

import com.daftduck.hermes.requests.TfLRequest;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StopPointByModeRequestTest {

    @Test
    public void shouldBuildRequestForRequiredFields() {
        TfLRequest request = new StopPointByModeRequest("app-id", "app-key", "dlr");

        assertThat(request.getRequest()).isEqualTo("https://api.tfl.gov.uk/StopPoint/Mode/dlr?app_id=app-id&app_key=app-key");
    }

}