package org.workspace7.openshift.che.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
public class Server {
  private String url;
  private String ref;
  private Map<Object, Object> properties;
  private String address;
  private String protocol;
}
