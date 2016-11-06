package com.daftduck.hermes.responses;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

public class HermesTestUtils {

    public static String loadResourceFor(String testName) throws IOException {
        URL url = Resources.getResource("responses/" + testName + ".json");
        return Resources.toString(url, Charsets.UTF_8);
    }

}
