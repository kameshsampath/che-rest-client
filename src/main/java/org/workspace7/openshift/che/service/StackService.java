package org.workspace7.openshift.che.service;


import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface StackService {

  @RequestLine("GET /api/stack?tags=tagQuery")
  String stacksByTags(@QueryMap Map<String, Object> queryParams);

  @RequestLine("GET /api/stack")
  String allStacks();

  @RequestLine("GET /api/stack/{stackId}")
  String stackById(@Param("stackId") String stackId);

}
