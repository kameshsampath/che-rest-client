package org.workspace7.openshift.che;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.workspace7.openshift.che.data.Stack;
import org.workspace7.openshift.che.service.StackClientService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StackQueryIT {

  @Autowired
  private StackClientService stackClientService;

  @Test
  public void workspaceQueryTest() {

    assertThat(stackClientService).isNotNull();

    List<Stack> workspaces = stackClientService.allStacks();

    assertThat(workspaces).isNotNull();
    assertThat(workspaces.isEmpty()).isFalse();
    assertThat(workspaces.size()).isGreaterThanOrEqualTo(1);
  }

}
