package com.daftduck.hermes;

import com.daftduck.hermes.responses.models.StopPointArrival;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class HermesTest {

    @Test
    public void shouldFindArrivalsForStopPoint() throws Exception {
        Hermes hermes = new Hermes("", "");

        List<StopPointArrival> stopPointArrivals = hermes.requestStopPointArrivals("490004380W");

        assertThat(stopPointArrivals).isNotEmpty();

        for (StopPointArrival arrival : stopPointArrivals) {
            assertThat(arrival.getNaptanId()).isEqualTo("490004380W");
        }
    }

}