package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceConfig {
  private String name;
  private String description;
  private String defaultEnv;
  private WorkspaceEnvironment environments;
  private List<Project> projects;
  private List<Command> commands;
}
