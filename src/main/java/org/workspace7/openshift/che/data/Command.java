package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Command {

  private String name;
  private String type;
  private String commandLine;
  private String workingDir;
  private CommandAttribute attributes;
}
