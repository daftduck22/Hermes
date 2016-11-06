package com.daftduck.hermes.Example;

import com.daftduck.hermes.Hermes;
import com.daftduck.hermes.HermesException;
import com.daftduck.hermes.responses.models.StopPointArrival;

import java.util.List;

public class ExampleUsage {

    public static void main(String[] args) throws HermesException {
        Hermes hermes = new Hermes("", "");

        List<StopPointArrival> arrivals = hermes.requestStopPointArrivals("490004380W");

        arrivals.sort((o1, o2) -> Long.compare(o1.getTimeToStation(), o2.getTimeToStation()));

        StopPointArrival nextArrival = arrivals.get(0);

        System.out.println(String.format("Next arrival at %s, is in %d:%02d.  VehicleId: %s",
                nextArrival.getStationName(),
                nextArrival.getTimeToStation() / 60,
                nextArrival.getTimeToStation() % 60,
                nextArrival.getVehicleId()));
    }

}
