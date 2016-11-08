package com.daftduck.hermes.responses;

import com.daftduck.hermes.HermesException;
import com.daftduck.hermes.responses.models.stoppoint.search.StopPointSearch;
import org.junit.Test;

import static com.daftduck.hermes.responses.HermesTestUtils.loadResourceFor;
import static org.fest.assertions.Assertions.assertThat;

public class StopPointSearchResponseTest {

    @Test
    public void shouldMapResponseCorrectly() throws Exception {
        String json = loadResourceFor("StopPointSearch");

        StopPointSearch search = new StopPointSearchResponse(json).mapResponse();

        assertThat(search.getType()).isEqualTo("Tfl.Api.Presentation.Entities.SearchResponse, Tfl.Api.Presentation.Entities");
        assertThat(search.getQuery()).isEqualTo("king");
        assertThat(search.getTotal()).isEqualTo(4);

        assertThat(search.getMatches()).hasSize(4);

        assertThat(search.getMatches().get(0).getType()).isEqualTo("Tfl.Api.Presentation.Entities.MatchedStop, Tfl.Api.Presentation.Entities");
        assertThat(search.getMatches().get(0).getIcsId()).isEqualTo("1000015");
        assertThat(search.getMatches().get(0).getModes()).hasSize(4).containsExactly("tube","overground","national-rail","bus");
        assertThat(search.getMatches().get(0).getId()).isEqualTo("HUBBKG");
        assertThat(search.getMatches().get(0).getName()).isEqualTo("Barking");
        assertThat(search.getMatches().get(0).getLat()).isEqualTo(51.539413);
        assertThat(search.getMatches().get(0).getLon()).isEqualTo(0.080988);
    }

    @Test(expected = HermesException.class)
    public void shouldThrowExceptionWhenUnmappable() throws Exception {
        new StopPointSearchResponse("[]").mapResponse();
    }

}