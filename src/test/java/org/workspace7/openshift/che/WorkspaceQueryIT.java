package org.workspace7.openshift.che;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.workspace7.openshift.che.data.Project;
import org.workspace7.openshift.che.data.ProjectSource;
import org.workspace7.openshift.che.data.Workspace;
import org.workspace7.openshift.che.service.WorkspaceClientService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkspaceQueryIT {

  @Autowired
  private WorkspaceClientService workspaceClientService;

  @Test
  public void workspaceQueryTest() {

    assertThat(workspaceClientService).isNotNull();

    List<Workspace> workspaces = workspaceClientService.allWorkspaces();

    assertThat(workspaces).isNotNull();
    assertThat(workspaces.isEmpty()).isFalse();
    assertThat(workspaces.size()).isGreaterThanOrEqualTo(1);
  }

  @Test
  public void workspaceCreateTest() {

    assertThat(workspaceClientService).isNotNull();

    String[] tags = {"maven", "java"};

    Map<Object, Object> projectAttributes = new HashMap<>();
    projectAttributes.put("language", new String[]{"java"});

    String stackId = "spring-boot";
    Project project = new Project();
    project.setName("console-java-simple");
    project.setPath("/console-java-simple");
    project.setCategory("samples");
    project.setTags(Arrays.asList(tags));
    project.setProjectType("maven");
    project.setAttributes(projectAttributes);
    project.setSource(ProjectSource.builder()
      .location("https://github.com/che-samples/console-java-simple.git")
      .type("git")
      .build());

    workspaceClientService.createWorkspace(stackId, "test-ws-two", project);
  }

}
