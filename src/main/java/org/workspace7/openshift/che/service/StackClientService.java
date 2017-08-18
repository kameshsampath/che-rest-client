package org.workspace7.openshift.che.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.workspace7.openshift.che.data.Stack;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class StackClientService {


  private StackService stackService;

  public StackClientService(StackService stackService) {
    this.stackService = stackService;
  }

  public List<Stack> allStacks() {
    log.info("Querying all Stacks");
    String stacksJson = stackService.allStacks();
    List<Stack> stacks = parseJson(stacksJson);
    if (stacks != null) return stacks;
    return Collections.emptyList();
  }

  public Stack stackById(String stackId) {
    log.info("Querying Stack for Id {}", stackId);
    try {
      String stacksJson = stackService.stackById(stackId);
      log.info("Stack {}", stacksJson);
      Stack stack = objectMapper().readValue(stacksJson, Stack.class);
      log.info("Retrieved Stack {}", stack);
      return stack;
    } catch (Exception e) {
      log.error("Error reading stack json", e);
    }
    return null;
  }


  public List<Stack> stackByTag(Map<String, Object> tagQueryMap) {
    log.info("Querying all Stacks");
    String stacksJson = stackService.stacksByTags(tagQueryMap);
    List<Stack> stacks = parseJson(stacksJson);
    return stacks;
  }


  protected com.fasterxml.jackson.core.type.TypeReference stackList() {
    com.fasterxml.jackson.core.type.TypeReference ref = new com.fasterxml.jackson.core.type.TypeReference<List<Stack>>() {
    };
    return ref;
  }

  protected ObjectMapper objectMapper() {
    return new ObjectMapper()
      .setSerializationInclusion(JsonInclude.Include.NON_NULL)
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }


  private List<Stack> parseJson(String stacksJson) {
    try {
      List<Stack> stacks = objectMapper().readValue(stacksJson, stackList());
      log.info("Retrieved {} stacks", stacks.size());
      return stacks;
    } catch (IOException e) {
      log.error("Error reading  stack json", e);
    }
    return Collections.emptyList();
  }
}
