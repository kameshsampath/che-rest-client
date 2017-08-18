package org.workspace7.openshift.che;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.workspace7.openshift.che.data.Workspace;
import org.workspace7.openshift.che.service.WorkspaceClientService;
import org.workspace7.openshift.che.service.WorkspaceService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkspaceQueryTest {

  @Autowired
  private WorkspaceClientService workspaceService;

  @Test
  public void workspaceQueryTest() {

    assertThat(workspaceService).isNotNull();

    List<Workspace> workspaces = workspaceService.allWorkspaces();

    assertThat(workspaces).isNotNull();
    assertThat(workspaces.isEmpty()).isFalse();
    assertThat(workspaces.size()).isGreaterThanOrEqualTo(1);
  }

}
