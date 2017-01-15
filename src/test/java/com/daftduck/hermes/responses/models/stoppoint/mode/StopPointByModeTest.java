package com.daftduck.hermes.responses.models.stoppoint.mode;

import com.daftduck.hermes.responses.models.common.AdditionalProperties;
import com.daftduck.hermes.responses.models.stoppoint.byid.StopPoint;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static com.daftduck.hermes.responses.HermesTestUtils.loadResourceFor;
import static org.fest.assertions.Assertions.assertThat;

public class StopPointByModeTest {

    @Test
    public void shouldMapResponseCorrectly() throws Exception {
        String json = loadResourceFor("StopPointByMode");

        StopPointsResponse stopPoints = new ObjectMapper().readValue(json, new TypeReference<StopPointsResponse>() {});

        assertThat(stopPoints.getStopPoints()).hasSize(260);
        assertThat(stopPoints.getPageSize()).isEqualTo(260);
        assertThat(stopPoints.getTotal()).isEqualTo(260);
        assertThat(stopPoints.getPage()).isEqualTo(1);

        StopPoint stopPoint = stopPoints.getStopPoints().get(1);
        assertThat(stopPoint.getType()).isEqualTo("Tfl.Api.Presentation.Entities.StopPoint, Tfl.Api.Presentation.Entities");
        assertThat(stopPoint.getNaptanId()).isEqualTo("4900ZZDLABR1");
        assertThat(stopPoint.getModes()).containsExactly("dlr");
        assertThat(stopPoint.getIcsCode()).isEqualTo("1003006");
        assertThat(stopPoint.getSmsCode()).isNull();
        assertThat(stopPoint.getStopType()).isEqualTo("NaptanMetroEntrance");
        assertThat(stopPoint.getStationNaptan()).isEqualTo("940GZZDLABR");

        assertThat(stopPoint.getLines()).isEmpty();

        assertThat(stopPoint.getLineGroup()).isEmpty();

        assertThat(stopPoint.getLineModeGroups()).isEmpty();

        assertThat(stopPoint.getStatus()).isEqualTo(true);
        assertThat(stopPoint.getId()).isEqualTo("4900ZZDLABR1");
        assertThat(stopPoint.getCommonName()).isEqualTo("Abbey Road DLR Station");
        assertThat(stopPoint.getPlaceType()).isEqualTo("StopPoint");

        assertThat(stopPoint.getAdditionalProperties()).hasSize(2);
        AdditionalProperties additionalProperties = stopPoint.getAdditionalProperties().get(0);
        assertThat(additionalProperties.getCategory()).isEqualTo("Facility");
        assertThat(additionalProperties.getKey()).isEqualTo("WiFi");
        assertThat(additionalProperties.getSourceSystemKey()).isEqualTo("StaticObjects");
        assertThat(additionalProperties.getValue()).isEqualTo("no");

        assertThat(stopPoint.getChildren()).hasSize(0);

        assertThat(stopPoint.getLat()).isEqualTo(51.532701d);
        assertThat(stopPoint.getLon()).isEqualTo(0.003699d);
    }

}
