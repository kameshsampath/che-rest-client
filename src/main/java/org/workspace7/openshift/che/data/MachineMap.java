package org.workspace7.openshift.che.data;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MachineMap {

  private Server servers;
  private List<String> agents;
  private Map<String, Object> attributes;
}
