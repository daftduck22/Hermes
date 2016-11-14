package com.daftduck.hermes.requests;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StopPointCategoriesMetadataRequestTest {

    @Test
    public void shouldBuildRequestForRequiredFields() {
        TfLRequest request = new StopPointCategoriesMetadataRequest("app-id", "app-key");

        assertThat(request.getRequest()).isEqualTo("https://api.tfl.gov.uk/StopPoint/Meta/categories?app_id=app-id&app_key=app-key");
    }

}