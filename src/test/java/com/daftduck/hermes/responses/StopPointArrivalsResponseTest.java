package com.daftduck.hermes.responses;

import com.daftduck.hermes.HermesException;
import com.daftduck.hermes.responses.models.stoppoint.arrivals.StopPointArrival;
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
        assertThat(arrivals.get(0).getLineId()).isEqualTo("piccadilly");
        assertThat(arrivals.get(0).getLineName()).isEqualTo("Piccadilly");
        assertThat(arrivals.get(0).getPlatformName()).isEqualTo("Eastbound - Platform 1");
        assertThat(arrivals.get(0).getDirection()).isEqualTo("outbound");
        assertThat(arrivals.get(0).getBearing()).isEqualTo("");
        assertThat(arrivals.get(0).getDestinationNaptanId()).isEqualTo("940GZZLUCKS");
        assertThat(arrivals.get(0).getDestinationName()).isEqualTo("Cockfosters Underground Station");
        assertThat(arrivals.get(0).getTimestamp()).isEqualTo("2016-11-06T17:17:26Z");
        assertThat(arrivals.get(0).getTimeToStation()).isEqualTo(538);
        assertThat(arrivals.get(0).getCurrentLocation()).isEqualTo("At Russell Square Platform 1");
        assertThat(arrivals.get(0).getTowards()).isEqualTo("Cockfosters");
        assertThat(arrivals.get(0).getExpectedArrival()).isEqualTo("2016-11-06T17:26:24.5319519Z");
        assertThat(arrivals.get(0).getTimeToLive()).isEqualTo("2016-11-06T17:26:24.5319519Z");
        assertThat(arrivals.get(0).getModeName()).isEqualTo("tube");
    }

    @Test(expected = HermesException.class)
    public void shouldThrowExceptionWhenUnmappable() throws Exception {
        new StopPointArrivalsResponse("{}").mapResponse();
    }

}
