package org.workspace7.openshift.che.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.workspace7.openshift.che.data.Workspace;
import org.workspace7.openshift.che.service.StackService;
import org.workspace7.openshift.che.service.WorkspaceService;

import java.util.List;

@Configuration
@Slf4j
public class CheApiHelperConfiguration {

  @Value("${eclipse.che.api.url}")
  String cheApiUrl;

  @Bean
  public StackService stackService() {
    log.info("Using Che API URL {}", cheApiUrl);
    return HystrixFeign.builder()
      .logLevel(Logger.Level.BASIC)
      .target(StackService.class, cheApiUrl);
  }

  @Bean
  public WorkspaceService workspaceService() {
    log.info("Using Che API URL {}", cheApiUrl);
    return HystrixFeign.builder()
      .logLevel(Logger.Level.BASIC)
      .target(WorkspaceService.class, cheApiUrl);
  }

}
