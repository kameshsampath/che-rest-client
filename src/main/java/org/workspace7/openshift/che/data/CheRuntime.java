package org.workspace7.openshift.che.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CheRuntime {
  private String activeEnv;
  private String rootFolder;
  private DevMachine devMachine;
  private List<MachineRuntime> machines;
}
