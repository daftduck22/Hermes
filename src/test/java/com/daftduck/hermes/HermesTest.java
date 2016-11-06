package com.daftduck.hermes;

import com.daftduck.hermes.responses.models.StopPointArrival;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class HermesTest {

    @Ignore
    @Test
    public void shouldFindArrivalsForStopPoint() throws Exception {
        Hermes hermes = new Hermes("", "");

        List<StopPointArrival> stopPointArrivals = hermes.requestStopPointArrivals("490004380W");

        assertThat(stopPointArrivals).isNotEmpty();

        for (StopPointArrival arrival : stopPointArrivals) {
            System.out.println("ARRIVAL: ");
            System.out.println("  $type:         " + arrival.getType());
            System.out.println("  id:            " + arrival.getId());
            System.out.println("  operationType: " + arrival.getOperationType());
            System.out.println("  naptanId:      " + arrival.getNaptanId());
            System.out.println("  stationName:   " + arrival.getStationName());
            System.out.println("  timeToStation: " + arrival.getTimeToStation());
        }
    }

}