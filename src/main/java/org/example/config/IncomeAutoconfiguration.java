package org.example.config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import service.IncomeClient;

@Configuration
@EnableConfigurationProperties(StarterIncomeProperties.class)
public class IncomeAutoconfiguration {
    @Bean
    public IncomeClient service(StarterIncomeProperties properties, RestTemplateBuilder builder) {
        return new IncomeClient(properties, restTemplate(builder));
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
