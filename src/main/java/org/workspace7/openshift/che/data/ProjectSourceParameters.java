package org.workspace7.openshift.che.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectSourceParameters {

  private String branch;
  private  String startPoint;
  private  boolean keepVcs;
  private String commitId;
  private  String keepDir;
  //TODO verify this
  private String fetch;
}
