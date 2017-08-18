package org.workspace7.openshift.che.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DevMachine {
  private String envName;
  private String id;
  private String owner;
  private String status;
  private MachineRuntime runtime;
  private WorkspaceConfig config;
}
