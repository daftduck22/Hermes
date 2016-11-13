package com.daftduck.hermes;

import com.daftduck.hermes.requests.StopPointArrivalsRequest;
import com.daftduck.hermes.requests.StopPointByIdRequest;
import com.daftduck.hermes.requests.StopPointSearchRequest;
import com.daftduck.hermes.requests.TfLRequest;
import com.daftduck.hermes.responses.ResponseMapper;
import com.daftduck.hermes.responses.models.stoppoint.arrivals.StopPointArrival;
import com.daftduck.hermes.responses.models.stoppoint.byid.StopPoint;
import com.daftduck.hermes.responses.models.stoppoint.search.StopPointSearch;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HermesTest {

    @Mock
    private HttpTfLRequestExecutor executor;
    @Mock
    private ResponseMapper mapper;
    @Mock
    private List<StopPointArrival> stopPointArrivals;
    @Mock
    private StopPointSearch stopPointSearch;
    @Mock
    private StopPoint stopPoint;

    private Hermes hermes;

    @Before
    public void beforeEachTest() throws HermesException {
        when(executor.execute(any(TfLRequest.class))).thenReturn("response-json");

        hermes = new Hermes("app-id", "app-key", executor, mapper);
    }

    @Test
    public void shouldFindArrivalsForStopPoint() throws Exception {
        when(mapper.mapResponse(eq("response-json"), any(TypeReference.class))).thenReturn(stopPointArrivals);

        assertThat(hermes.requestStopPointArrivals("stop-point-id")).isEqualTo(stopPointArrivals);

        verify(executor).execute(any(StopPointArrivalsRequest.class));
        verify(mapper).mapResponse(eq("response-json"), any(TypeReference.class));
    }

    @Test
    public void shouldSearchForStopPoint() throws Exception {
        when(mapper.mapResponse(eq("response-json"), any(TypeReference.class))).thenReturn(stopPointSearch);

        assertThat(hermes.requestStopPointSearch("query", "modes")).isEqualTo(stopPointSearch);

        verify(executor).execute(any(StopPointSearchRequest.class));
        verify(mapper).mapResponse(eq("response-json"), any(TypeReference.class));
    }

    @Test
    public void shouldGetStopPointById() throws Exception {
        when(mapper.mapResponse(eq("response-json"), any(TypeReference.class))).thenReturn(stopPoint);

        assertThat(hermes.requestStopPointById("stop-point-id")).isEqualTo(stopPoint);

        verify(executor).execute(any(StopPointByIdRequest.class));
        verify(mapper).mapResponse(eq("response-json"), any(TypeReference.class));
    }

}