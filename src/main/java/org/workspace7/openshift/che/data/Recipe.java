package org.workspace7.openshift.che.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Recipe {

  private String contentType;
  private String type;
  private String content;
  private String location;

}
