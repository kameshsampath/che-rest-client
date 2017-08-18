package org.workspace7.openshift.che.data;

import lombok.Data;

@Data
public class ProjectSource {
  private String type;
  private String location;
  private ProjectSourceParameters parameters;
}
