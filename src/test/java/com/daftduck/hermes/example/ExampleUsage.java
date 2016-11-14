package com.daftduck.hermes.example;

import com.daftduck.hermes.Hermes;
import com.daftduck.hermes.HermesException;
import com.daftduck.hermes.responses.models.stoppoint.arrivals.StopPointArrival;
import com.daftduck.hermes.responses.models.stoppoint.search.SearchResponse;
import com.daftduck.hermes.responses.models.stoppoint.search.MatchedStop;
import com.google.common.base.Joiner;

import java.util.List;

public class ExampleUsage {

    public static void main(String[] args) throws HermesException {
        Hermes hermes = new Hermes("", "");

        requestStopPointSearch(hermes, "king", "tube");

        System.out.println("---");

        requestStopPointArrivals(hermes);

    }

    private static void requestStopPointSearch(Hermes hermes, String query, String modes) throws HermesException {
        SearchResponse search = hermes.requestStopPointSearch(query, modes);

        System.out.println(String.format("StopPoint search found %s matches for '%s':", search.getTotal(), search.getQuery()));

        for (MatchedStop match : search.getMatches()) {
            System.out.println(String.format("  %s: %s - %s", match.getId(), match.getName(), Joiner.on(", ").join(match.getModes())));
        }
    }

    private static void requestStopPointArrivals(Hermes hermes) throws HermesException {
        String stopPointId = "940GZZDLSIT";
        List<StopPointArrival> arrivals = hermes.requestStopPointArrivals(stopPointId);

        arrivals.sort((o1, o2) -> Long.compare(o1.getTimeToStation(), o2.getTimeToStation()));

        System.out.println(String.format("StopPoint arrivals found %s arrivals for '%s':", arrivals.size(), stopPointId));

        for (StopPointArrival nextArrival : arrivals) {
            System.out.println(String.format("  Next arrival at %s, is in %d:%02d.  VehicleId: %s",
                    nextArrival.getStationName(),
                    nextArrival.getTimeToStation() / 60,
                    nextArrival.getTimeToStation() % 60,
                    nextArrival.getVehicleId()));
        }
    }

}
