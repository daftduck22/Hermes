package com.daftduck.hermes.responses.models.stoppoint.search;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static com.daftduck.hermes.responses.HermesTestUtils.loadResourceFor;
import static org.fest.assertions.Assertions.assertThat;

public class StopPointSearchTest {

    @Test
    public void shouldMapResponseCorrectly() throws Exception {
        String json = loadResourceFor("StopPointSearch");

        SearchResponse search = new ObjectMapper().readValue(json, new TypeReference<SearchResponse>() {});

        assertThat(search.getQuery()).isEqualTo("king");
        assertThat(search.getTotal()).isEqualTo(4);

        assertThat(search.getMatches()).hasSize(4);

        assertThat(search.getMatches().get(0).getIcsId()).isEqualTo("1000015");
        assertThat(search.getMatches().get(0).getModes()).hasSize(4).containsExactly("tube","overground","national-rail","bus");
        assertThat(search.getMatches().get(0).getId()).isEqualTo("HUBBKG");
        assertThat(search.getMatches().get(0).getName()).isEqualTo("Barking");
        assertThat(search.getMatches().get(0).getLat()).isEqualTo(51.539413);
        assertThat(search.getMatches().get(0).getLon()).isEqualTo(0.080988);
    }

}