package com.sstpath.marketplace.payment.config;

import feign.RequestInterceptor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.chip-collect")
@Setter
public class ChipFeignConfig {

    private String apiKey;

    @Bean
    public RequestInterceptor chipAuthInterceptor() {
        return template -> {
            template.header("Authorization", "Bearer "+ apiKey);
            template.header("Content-Type", "application/json");
        };
    }
}