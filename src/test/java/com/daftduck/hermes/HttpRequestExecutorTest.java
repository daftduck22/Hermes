package com.daftduck.hermes;

import com.daftduck.hermes.requests.TfLRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HttpRequestExecutorTest {

    @Mock
    private TfLRequest request;

    private HttpTfLRequestExecutor executor = new HttpTfLRequestExecutor();

    @Test
    public void shouldCallUrlAndReturnResponse() throws Exception {
        when(request.getRequest()).thenReturn("http://www.google.com");

        String response = executor.execute(request);

        assertThat(response).isNotNull().containsIgnoringCase("<title>Google</title>");
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenSomethingsGoesWrong() throws Exception {
        doThrow(new Exception()).when(request.getRequest());

        executor.execute(request);
    }

}