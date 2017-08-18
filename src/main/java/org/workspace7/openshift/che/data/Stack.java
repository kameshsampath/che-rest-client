package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stack {
  private String description;
  private String scope;
  private StackSource source;
  private List<String> tags;
  private WorkspaceConfig workspaceConfig;
  private List<StackComponent> components;
  private String creator;
  private String name;
  private String id;
}
