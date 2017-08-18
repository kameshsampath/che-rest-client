package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Command {

  private String name;
  private String type;
  private String commandLine;
  private String workingDir;
  private CommandAttribute attributes;
}
