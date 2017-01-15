package com.daftduck.hermes.requests.stoppoint;

import com.daftduck.hermes.requests.TfLRequest;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StopPointByModeTest {

    @Test
    public void shouldBuildRequestForRequiredFields() {
        TfLRequest request = new StopPointByMode("app-id", "app-key", "dlr");

        assertThat(request.getRequest()).isEqualTo("https://api.tfl.gov.uk/StopPoint/Mode/dlr?app_id=app-id&app_key=app-key");
    }

}