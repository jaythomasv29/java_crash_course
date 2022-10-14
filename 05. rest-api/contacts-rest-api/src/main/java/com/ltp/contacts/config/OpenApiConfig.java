package com.ltp.contacts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
      .info(new Info().title("Contacts API")
      .description("An API that can manage contacts")
      .version("v1.0")
      );
  }
}
