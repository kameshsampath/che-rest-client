package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectModule {

  private String name;
  private String description;
  private String path;
  private String type;
  private Map<String, Object> attributes;
  private List<String> mixins;
}
