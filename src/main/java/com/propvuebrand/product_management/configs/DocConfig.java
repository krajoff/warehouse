package com.propvuebrand.product_management.configs;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Конфигурационный класс для настройки документации Swagger OpenAPI.
 */
@Configuration
public class DocConfig {

    /**
     * Настройка группировки API для продуктов.
     *
     * @return конфигурация группировки API, включающая все эндпоинты,
     * соответствующие пути `/products/**`
     */
    @Bean
    public GroupedOpenApi publicProductApi() {
        return GroupedOpenApi.builder()
                .group("Products")
                .pathsToMatch("/products/**")
                .build();
    }

    /**
     * Настройка общей информации об API.
     *
     * @param appDescription описание приложения
     * @param appVersion версия приложения
     * @return объект OpenAPI с настройками информации об API, лицензии и серверов
     */
    @Bean
    public OpenAPI customOpenApi(@Value("Product management")String appDescription,
                                 @Value("0.0.1")String appVersion) {
        return new OpenAPI().info(new Info().title("Product management API")
                        .version(appVersion)
                        .description(appDescription)
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .contact(new Contact().name("username")
                                .email("uzu.mail@gmail.com")))
                .servers(List.of(new Server().url("http://localhost:8080")
                                .description("Dev service"),
                        new Server().url("http://localhost:8082")
                                .description("Beta service")));
    }
}
