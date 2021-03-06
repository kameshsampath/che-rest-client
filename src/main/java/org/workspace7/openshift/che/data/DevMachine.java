package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DevMachine {
  private String envName;
  private String id;
  private String owner;
  private String status;
  private MachineRuntime runtime;
  private WorkspaceConfig config;
}
