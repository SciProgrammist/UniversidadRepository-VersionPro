package com.springsimplepasos.universidad.universidadbackend.configuration;

import com.fasterxml.classmate.ResolvedType;
import com.springsimplepasos.universidad.universidadbackend.modelo.dto.CarreraDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxSwagger {

/*    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springsimplepasos.universidad.universidadbackend.controlador.dto"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Universidad Backend API",
                "API para el manejo de nuestra universidad",
                "V2",
                "Terminos del servicio",
                new Contact("Matias Macrino", "www.google.com", "mm@gmail.com"),
                "Licencia de API", "API licencia url", Collections.emptyList()
        );
    }*/

}
