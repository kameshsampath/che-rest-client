package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceEnvironment {

  @JsonProperty("machines")
  private Map<String, MachineMap> machines;

  @JsonProperty("recipe")
  private Recipe recipe;
}
