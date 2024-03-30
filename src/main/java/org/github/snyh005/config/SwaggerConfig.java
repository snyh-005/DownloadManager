package org.github.snyh005.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(new Info()
                .title("Download Manager")
                .description("Java application that simulates a download manager capable of downloading multiple files concurrently.")
                .version("1.0"));
        openAPI.setServers(Collections.singletonList(new Server().url("http://localhost:8080")));
        openAPI.setPaths(new Paths());
        return openAPI;
    }
}
