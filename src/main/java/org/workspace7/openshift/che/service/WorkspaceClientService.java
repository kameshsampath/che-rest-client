package org.workspace7.openshift.che.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.workspace7.openshift.che.data.*;
import org.workspace7.openshift.che.requests.WorkspaceRequest;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class WorkspaceClientService {


  private final StackClientService stackClientService;
  private WorkspaceService workspaceService;

  public WorkspaceClientService(WorkspaceService workspaceService, StackClientService stackClientService) {
    this.workspaceService = workspaceService;
    this.stackClientService = stackClientService;
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

  public String createWorkspace(String stackId, String workspaceName, Project project) {

    log.info("Creating Workspace {}", workspaceName);

    Stack stack = stackClientService.stackById(stackId);

    if (stack != null) {

      List<Command> commands = stack.getWorkspaceConfig().getCommands();

      WorkspaceEnvironment environments = stack.getWorkspaceConfig().getEnvironments();

      WorkspaceRequest workspaceRequest = WorkspaceRequest.builder().commands(commands)
        .name(workspaceName)
        .defaultEnv(stack.getWorkspaceConfig().getDefaultEnv())
        .projects(Collections.singletonList(project)) //FIXME update it
        .environments(environments)
        .build();

      StringWriter stringWriter = new StringWriter();

      try {
        objectMapper().writeValue(stringWriter, workspaceRequest);
        stringWriter.flush();
        String workspaceRequestJson = stringWriter.toString();
        log.info("Workspace Create Request:{}", workspaceRequestJson);
        String response = workspaceService.createWorkspace(workspaceRequestJson);
        log.info("Workspace Create Response {}", response);
        stringWriter.close();
      } catch (IOException e) {
        log.error("Unable to create workspace {}", workspaceName, e);
      }


    } else {
      log.warn("No Stack available with id {}", stackId);
    }
    return "";
  }


  protected com.fasterxml.jackson.core.type.TypeReference workspaceList() {
    com.fasterxml.jackson.core.type.TypeReference ref = new com.fasterxml.jackson.core.type.TypeReference<List<Workspace>>() {
    };
    return ref;
  }

  protected ObjectMapper objectMapper() {
    return new ObjectMapper()
      .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
      .setSerializationInclusion(JsonInclude.Include.NON_NULL)
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}
