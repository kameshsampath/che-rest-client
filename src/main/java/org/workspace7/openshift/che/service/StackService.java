package org.workspace7.openshift.che.service;


import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface StackService {

  @RequestLine("GET /api/stack?tags=tagQuery")
  String stacksByTags(@QueryMap  Map<String,Object> queryParams);

  @RequestLine("GET /api/stack")
  String allStacks();

}
