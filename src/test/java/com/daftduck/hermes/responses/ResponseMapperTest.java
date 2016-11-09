package com.daftduck.hermes.responses;

import com.daftduck.hermes.HermesException;
import com.daftduck.hermes.responses.models.stoppoint.search.StopPointSearch;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ResponseMapperTest {

    private ResponseMapper mapper = new ResponseMapper();

    @Test
    public void shouldMapCorrectly() throws HermesException {
        StopPointSearch search = mapper.mapResponse("{\"$type\": \"walking\"}", new TypeReference<StopPointSearch>() {});
        assertThat(search.getType()).isEqualTo("walking");
    }

    @Test(expected = HermesException.class)
    public void shouldThrowExceptionIfUnmappable() throws HermesException {
        mapper.mapResponse("jdfaslkdsa", new TypeReference<StopPointSearch>() {});
    }

}