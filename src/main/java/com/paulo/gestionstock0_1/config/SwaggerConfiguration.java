package com.paulo.gestionstock0_1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        info = @Info(
                title = "Gestion de stock REST API",
                description = "Gestion de stock API documentation",
                summary = "Cette doc api va faire resortir create, deleteand update,  ",
                contact = @Contact(
                        name = "TOURE KATINAN",
                        email = "katine.toure95@gmail.com"
                ),
                license = @License(
                        name = "Pas de licence"
                ),
                version = "V1"
        )
)
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI();
        // Vous pouvez ajouter plus de configurations personnalisées ici si nécessaire.
    }

    /*@Bean
    public OpenAPI  api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Gestion de stock API documentation")
                                .title("Gestion de stock REST API")
                                .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.paulo.gestionstock0_1"))
                .paths(PathSelectors.ant(APP_ROOT + "/**"))
                .build();
    }
*/


}

