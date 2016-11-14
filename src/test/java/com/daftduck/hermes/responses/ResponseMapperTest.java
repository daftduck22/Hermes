package com.daftduck.hermes.responses;

import com.daftduck.hermes.HermesException;
import com.daftduck.hermes.responses.models.stoppoint.search.SearchResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ResponseMapperTest {

    private ResponseMapper mapper = new ResponseMapper();

    @Test
    public void shouldMapCorrectly() throws HermesException {
        SearchResponse search = mapper.mapResponse("{\"$type\": \"walking\"}", new TypeReference<SearchResponse>() {});
        assertThat(search.getType()).isEqualTo("walking");
    }

    @Test(expected = HermesException.class)
    public void shouldThrowExceptionIfUnmappable() throws HermesException {
        mapper.mapResponse("jdfaslkdsa", new TypeReference<SearchResponse>() {});
    }

}