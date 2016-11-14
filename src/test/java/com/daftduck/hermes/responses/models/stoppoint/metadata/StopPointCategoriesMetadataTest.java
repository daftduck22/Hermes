package com.daftduck.hermes.responses.models.stoppoint.metadata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.List;

import static com.daftduck.hermes.responses.HermesTestUtils.loadResourceFor;
import static org.fest.assertions.Assertions.assertThat;

public class StopPointCategoriesMetadataTest {

    @Test
    public void shouldMapResponseCorrectly() throws Exception {
        String json = loadResourceFor("StopPointCategoriesMetadata");

        List<StopPointCategory> stopPointCategories = new ObjectMapper().readValue(json, new TypeReference<List<StopPointCategory>>() {});

        assertThat(stopPointCategories).hasSize(7);

        StopPointCategory category = stopPointCategories.get(1);

        assertThat(category.getType()).isEqualTo("Tfl.Api.Presentation.Entities.StopPointCategory, Tfl.Api.Presentation.Entities");
        assertThat(category.getCategory()).isEqualTo("Address");
        assertThat(category.getAvailableKeys()).containsExactly("PhoneNo", "Address");
    }

}
