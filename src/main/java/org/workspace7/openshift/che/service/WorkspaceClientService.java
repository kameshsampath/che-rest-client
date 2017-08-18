package org.workspace7.openshift.che.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.workspace7.openshift.che.data.Workspace;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class WorkspaceClientService {


  private WorkspaceService workspaceService;

  public WorkspaceClientService(WorkspaceService workspaceService) {
    this.workspaceService = workspaceService;
  }

  public List<Workspace> allWorkspaces() {
    log.info("Querying all workspaces");
    String workspaceJson = workspaceService.allWorkspaces();
    try {
      List<Workspace> workspaces = objectMapper().readValue(workspaceJson, workspaceList());
      log.info("Retrieved {} workspaces", workspaces.size());
      return workspaces;
    } catch (IOException e) {
      log.error("Error reading  workspace json", e);
    }
    return Collections.emptyList();
  }


  protected com.fasterxml.jackson.core.type.TypeReference workspaceList() {
    com.fasterxml.jackson.core.type.TypeReference ref = new com.fasterxml.jackson.core.type.TypeReference<List<Workspace>>() {
    };
    return ref;
  }

  protected ObjectMapper objectMapper() {
    return new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}
