package org.workspace7.openshift.che.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.workspace7.openshift.che.data.Command;
import org.workspace7.openshift.che.data.Project;
import org.workspace7.openshift.che.data.WorkspaceEnvironment;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceRequest {

  private String name;
  private List<Command> commands;
  private WorkspaceEnvironment environments;
  private String defaultEnv;
  private List<Project> projects;
}
