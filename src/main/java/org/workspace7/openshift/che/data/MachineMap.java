package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MachineMap {

  @JsonProperty("dev-machine")
  private MachineMap devMachine;
  private Server servers;
  private List<String> agents;
  private Map<String, Object> attributes;
}
