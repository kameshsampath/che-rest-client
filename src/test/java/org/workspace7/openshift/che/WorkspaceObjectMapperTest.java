package org.workspace7.openshift.che;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.workspace7.openshift.che.data.Workspace;

import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//TODO more test cases to add
public class WorkspaceObjectMapperTest {

  @Test
  public void testDeserialize() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    TypeReference ref = new TypeReference<List<Workspace>>() {
    };

    InputStream json = this.getClass().getResourceAsStream("/workspaces.json");

    List<Workspace> workspaces = objectMapper.readValue(json, ref);

    assertThat(workspaces).isNotNull();
    assertThat(workspaces.isEmpty()).isFalse();
    assertThat(workspaces.size()).isGreaterThanOrEqualTo(1);

    assertThat(workspaces.get(0).getConfig().getDefaultEnv()).isEqualToIgnoringCase("default");
  }

}
