package org.workspace7.openshift.che;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.workspace7.openshift.che.data.Stack;
import org.workspace7.openshift.che.data.WorkspaceEnvironment;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//TODO more test cases to add
public class StackObjectMapperTest {

  @Test
  public void testDeserialize() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    TypeReference ref = new TypeReference<List<Stack>>() {
    };

    InputStream json = this.getClass().getResourceAsStream("/stack.json");

    List<Stack> stacks = objectMapper.readValue(json, ref);

    assertThat(stacks).isNotNull();
    assertThat(stacks.isEmpty()).isFalse();
    assertThat(stacks.size()).isGreaterThanOrEqualTo(1);

    assertThat(stacks.get(0).getName()).isEqualToIgnoringCase("Spring Boot");
    assertThat(stacks.get(0).getWorkspaceConfig().getDefaultEnv()).isEqualToIgnoringCase("default");
    assertThat(stacks.get(0).getTags()).contains("Java", "JDK", "Maven", "Spring Boot", "CentOS", "Git");
    assertThat(stacks.get(0).getWorkspaceConfig().getCommands().size()).isGreaterThanOrEqualTo(3);

  }

  @Test
  public void testDeserializeSingleStack() throws Exception {

    ObjectMapper objectMapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    InputStream json = this.getClass().getResourceAsStream("/spring-boot-stack.json");

    Stack stack = objectMapper.readValue(json, Stack.class);

    assertThat(stack).isNotNull();
    assertThat(stack.getName()).isEqualToIgnoringCase("Spring Boot");
    assertThat(stack.getWorkspaceConfig().getDefaultEnv()).isEqualToIgnoringCase("default");
    assertThat(stack.getTags()).contains("Java", "JDK", "Maven", "Spring Boot", "CentOS", "Git");
    assertThat(stack.getWorkspaceConfig().getCommands().size()).isGreaterThanOrEqualTo(3);

    WorkspaceEnvironment workspaceEnvironment = stack.getWorkspaceConfig().getEnvironments();
    assertThat(workspaceEnvironment).isNotNull();

    StringWriter stringWriter = new StringWriter();

    new ObjectMapper().writeValue(stringWriter, workspaceEnvironment);

    System.out.println(stringWriter.toString());

    assertThat(workspaceEnvironment.getDefaultWorkspaceEnv().getMachines()).isNotNull();


  }

}
