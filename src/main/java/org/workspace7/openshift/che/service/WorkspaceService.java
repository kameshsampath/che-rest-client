package org.workspace7.openshift.che.service;


import feign.RequestLine;
import org.springframework.stereotype.Service;
import org.workspace7.openshift.che.data.Workspace;

import javax.websocket.server.PathParam;
import java.util.List;

@Service

public interface WorkspaceService {

  @RequestLine("GET /api/workspace")
  String allWorkspaces();

  @RequestLine("GET /api/workspace/name/{wsName}")
  String checkWorkspace(@PathParam("wsName") String workspaceName);

  //void createWorkspace(String workspaceJson);

}
