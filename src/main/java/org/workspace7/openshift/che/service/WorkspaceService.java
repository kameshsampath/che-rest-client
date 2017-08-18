package org.workspace7.openshift.che.service;


import feign.Headers;
import feign.RequestLine;
import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;

@Service

public interface WorkspaceService {

  @RequestLine("GET /api/workspace")
  String allWorkspaces();

  @RequestLine("GET /api/workspace/name/{wsName}")
  String checkWorkspace(@PathParam("wsName") String workspaceName);

  @RequestLine("POST /api/workspace")
  @Headers("Content-Type: application/json")
  String createWorkspace(String workspaceRequest);

}
