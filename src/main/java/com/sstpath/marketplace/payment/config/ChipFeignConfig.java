package com.sstpath.marketplace.payment.config;

import java.time.Instant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "app.chip-collect")
@Setter
public class ChipFeignConfig {

    private String apiKey;
    private String secret;

    @Bean
    public RequestInterceptor chipAuthInterceptor() {
        return requestTemplate -> {
            long epoch = Instant.now().getEpochSecond();
            String data = epoch + apiKey;

            String checksum = HmacUtils.hmacSha512Hex(secret, data);

            requestTemplate.header("Authorization", "Bearer " + apiKey);
            requestTemplate.header("Epoch", String.valueOf(epoch));
            requestTemplate.header("Checksum", checksum);
        };
    }
}
