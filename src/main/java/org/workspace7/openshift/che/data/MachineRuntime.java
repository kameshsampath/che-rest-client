package org.workspace7.openshift.che.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
public class MachineRuntime {

  private String projectsRoot;
  private Map<Object,Object> properties;
  private Map<Object,Object> envVariables;
  private Server server;
}
