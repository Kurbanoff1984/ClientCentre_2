package org.kata.clientprofileloader.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.AllArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@AllArgsConstructor
@OpenAPIDefinition(
        info = @Info(
                title = "API для получения нужных сущностей ",
                description = "получение сущностей", version = "1.0.0",
                contact = @Contact(
                        name = "Savin Danil"
                )
        )
)
public class SwaggerConfig {
    private ApplicationContext applicationContext;

    @Bean
    public List<GroupedOpenApi> apis() {
        List<GroupedOpenApi> groups = new ArrayList<>();
        Map<String, Object> controllerBeans = applicationContext.getBeansWithAnnotation(RestController.class);
        for (Object controllerBean : controllerBeans.values())
            if (controllerBean instanceof RestController) {
                Class<?> controllerClass = controllerBean.getClass();
                String packageName = String.valueOf(controllerClass.getPackage().getClass());
                GroupedOpenApi groupedOpenApi = GroupedOpenApi.builder()
                        .group(packageName)
                        .packagesToScan(packageName)
                        .build();
                groups.add(groupedOpenApi);
            }
        return groups;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI();
    }


}
