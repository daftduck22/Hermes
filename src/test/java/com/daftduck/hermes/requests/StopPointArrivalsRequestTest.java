package com.daftduck.hermes.requests;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StopPointArrivalsRequestTest {

    @Test
    public void shouldBuildRequestForRequiredFields() {
        TfLRequest request = new StopPointArrivalsRequest("app-id", "app-key", "stop-point-id");

        assertThat(request.getRequest()).isEqualTo("https://api.tfl.gov.uk/StopPoint/stop-point-id/Arrivals?app_id=app-id&app_key=app-key");
    }

}