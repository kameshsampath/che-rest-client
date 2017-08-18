package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Workspace {
  private String id;
  private String namespace;
  private boolean isTemporary;
  private Map<String, String> attributes;
  private CheRuntime runtime;
  @JsonProperty("config")
  private WorkspaceConfig config;

}
