package com.javainuse.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build().apiInfo(apiInfo()).useDefaultResponseMessages(false)
                  .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500)
                          .message("500 message")
                          .responseModel(new ModelRef("Error"))
                          .build(),
                          new ResponseMessageBuilder().code(403)
                              .message("Forbidden!!!!!")
                              .build()));                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot Angular Application",
                "Spring Boot Angular Application REST API Documentation.",
                "API TOS",
                "http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open",
                new Contact("Software Team", "mdilan1988@gmail.com", "mdilan1988@gmail.com"),
                "Apache License Version 2.0", "https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE",
                Collections.emptyList());
    }

}