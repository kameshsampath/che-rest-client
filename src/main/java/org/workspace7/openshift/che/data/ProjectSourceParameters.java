package org.workspace7.openshift.che.data;

import lombok.Data;

@Data
public class ProjectSourceParameters {

  private String branch;
  private  String startPoint;
  private  boolean keepVcs;
  private String commitId;
  private  String keepDir;
  //TODO verify this
  private String fetch;
}
