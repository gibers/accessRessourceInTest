package com.example.bern.accessRessourceInTest.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {

    @Bean
    String getVersion() {
        return "1234.12";
    }

}
