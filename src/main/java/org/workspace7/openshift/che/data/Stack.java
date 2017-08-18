package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
