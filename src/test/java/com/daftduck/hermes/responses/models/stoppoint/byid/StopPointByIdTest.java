package com.daftduck.hermes.responses.models.stoppoint.byid;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static com.daftduck.hermes.responses.HermesTestUtils.loadResourceFor;
import static org.fest.assertions.Assertions.assertThat;

public class StopPointByIdTest {

    @Test
    public void shouldMapResponseCorrectly() throws Exception {
        String json = loadResourceFor("StopPointById");

        StopPoint stopPoint = new ObjectMapper().readValue(json, new TypeReference<StopPoint>() {});

        assertThat(stopPoint.getNaptanId()).isEqualTo("490G00004380");
        assertThat(stopPoint.getModes()).containsExactly("bus");
        assertThat(stopPoint.getIcsCode()).isEqualTo("1004380");
        assertThat(stopPoint.getSmsCode()).isEqualTo("51678");
        assertThat(stopPoint.getStopType()).isEqualTo("NaptanOnstreetBusCoachStopPair");
        assertThat(stopPoint.getStationNaptan()).isEqualTo("490G00004380");

        assertThat(stopPoint.getLines()).hasSize(2);
        assertThat(stopPoint.getLines().get(0).getId()).isEqualTo("132");
        assertThat(stopPoint.getLines().get(0).getName()).isEqualTo("132");
        assertThat(stopPoint.getLines().get(0).getUri()).isEqualTo("/Line/132");
        assertThat(stopPoint.getLines().get(0).getType()).isEqualTo("Line");

        assertThat(stopPoint.getLineGroup()).hasSize(2);
        assertThat(stopPoint.getLineGroup().get(0).getNaptanIdReference()).isEqualTo("490004380E");
        assertThat(stopPoint.getLineGroup().get(0).getStationAtcoCode()).isEqualTo("490G00004380");
        assertThat(stopPoint.getLineGroup().get(0).getLineIdentifier()).containsExactly("132", "286");

        assertThat(stopPoint.getLineModeGroups()).hasSize(1);
        assertThat(stopPoint.getLineModeGroups().get(0).getModeName()).isEqualTo("bus");
        assertThat(stopPoint.getLineModeGroups().get(0).getLineIdentifier()).containsExactly("132", "286");

        assertThat(stopPoint.getStatus()).isEqualTo(true);
        assertThat(stopPoint.getId()).isEqualTo("490G00004380");
        assertThat(stopPoint.getCommonName()).isEqualTo("Rochester Way / Broad Walk");
        assertThat(stopPoint.getPlaceType()).isEqualTo("StopPoint");

        assertThat(stopPoint.getAdditionalProperties()).hasSize(0);

        assertThat(stopPoint.getChildren()).hasSize(2);
        StopPoint child = stopPoint.getChildren().get(0);
        assertThat(child.getNaptanId()).isEqualTo("490004380E");
        assertThat(child.getIndicator()).isEqualTo("Stop A");
        assertThat(child.getStopLetter()).isEqualTo("A");

        assertThat(stopPoint.getLat()).isEqualTo(51.464697d);
        assertThat(stopPoint.getLon()).isEqualTo(0.033515d);
    }

}
