package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {

  private String name;
  private String displayName;
  private String path;
  private List<String> tags;
  private List<Command> commands;
  private List<Project> projects;

  private String type;
  private String projectType;
  private String category;
  private String description;

  private ProjectSource source;
  private List<String> mixins;
  private List<String> problems;

  private Map<Object, Object> properties;
  private Map<Object, Object> options;
  private Map<Object, Object> attributes;

  private List<ProjectModule> modules;
}
