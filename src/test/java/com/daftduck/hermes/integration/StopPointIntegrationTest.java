package com.daftduck.hermes.integration;

import com.daftduck.hermes.Hermes;
import com.daftduck.hermes.HermesException;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StopPointIntegrationTest {

    private Hermes hermes;

    @Before
    public void beforeAllTests() {
        hermes = new Hermes("", "");
    }

    @Test
    public void canCallStopPointCategoriesMetadata() throws HermesException {
        assertThat(hermes.requestStopPointCategoriesMetadata().size()).isPositive();
    }

    @Test
    public void canCallStopPointArrivals() throws HermesException {
        assertThat(hermes.requestStopPointArrivals("940GZZDLSIT").size()).isPositive();
    }

    @Test
    public void shouldCallStopPointByMode() throws HermesException {
       assertThat(hermes.requestStopPointByMode("dlr").getStopPoints()).isNotEmpty();
    }

    @Test
    public void canCallStopPointById() throws HermesException {
        assertThat(hermes.requestStopPointById("940GZZDLSIT").getModes()).contains("bus");
    }

    @Test
    public void canCallStopPointSearch() throws HermesException {
        assertThat(hermes.requestStopPointSearch("wharf", "tube").getMatches().size()).isPositive();
    }

}
