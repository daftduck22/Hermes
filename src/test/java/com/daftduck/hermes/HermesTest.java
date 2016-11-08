package com.daftduck.hermes;

import com.daftduck.hermes.requests.StopPointArrivalsRequest;
import com.daftduck.hermes.requests.StopPointSearchRequest;
import com.daftduck.hermes.responses.models.stoppoint.arrivals.StopPointArrival;
import com.daftduck.hermes.responses.models.stoppoint.search.StopPointSearch;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HermesTest {

    @Mock
    private HttpTfLRequestExecutor executor;

    private Hermes hermes;

    @Before
    public void beforeEachTest() {
        hermes = new Hermes("app-id", "app-key", executor);
    }

    @Test
    public void shouldFindArrivalsForStopPoint() throws Exception {
        when(executor.execute(any(StopPointArrivalsRequest.class))).thenReturn("[]");

        List<StopPointArrival> stopPointArrivals = hermes.requestStopPointArrivals("stop-point-id");

        verify(executor).execute(any(StopPointArrivalsRequest.class));
        assertThat(stopPointArrivals).isEmpty();
    }

    @Test
    public void shouldSearchForStopPoint() throws Exception {
        when(executor.execute(any(StopPointSearchRequest.class))).thenReturn("{}");

        StopPointSearch stopPointSearch = hermes.requestStopPointSearch("query", "modes");

        verify(executor).execute(any(StopPointSearchRequest.class));
        assertThat(stopPointSearch).isNotNull();
    }

}