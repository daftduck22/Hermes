package com.daftduck.hermes.responses;

import com.daftduck.hermes.responses.models.StopPointArrival;
import org.junit.Test;

import java.util.List;

import static com.daftduck.hermes.responses.HermesTestUtils.loadResourceFor;
import static org.fest.assertions.Assertions.assertThat;

public class StopPointArrivalsResponseTest {

    @Test
    public void shouldMapResponseCorrectly() throws Exception {
        String json = loadResourceFor("StopPointArrivals");

        List<StopPointArrival> arrivals = new StopPointArrivalsResponse(json).mapResponse();

        assertThat(arrivals).hasSize(17);

        assertThat(arrivals.get(0).getType()).isEqualTo("Tfl.Api.Presentation.Entities.Prediction, Tfl.Api.Presentation.Entities");
        assertThat(arrivals.get(0).getId()).isEqualTo("-1443103753");
        assertThat(arrivals.get(0).getOperationType()).isEqualTo("1");
        assertThat(arrivals.get(0).getVehicleId()).isEqualTo("226");
        assertThat(arrivals.get(0).getNaptanId()).isEqualTo("940GZZLUASL");
        assertThat(arrivals.get(0).getStationName()).isEqualTo("Arsenal Underground Station");
        assertThat(arrivals.get(0).getTimeToStation()).isEqualTo(538);
    }

}
