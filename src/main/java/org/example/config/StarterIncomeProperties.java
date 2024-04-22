package org.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Setter
@Getter
@ConfigurationProperties(prefix = "starter-income")
public class StarterIncomeProperties {
    private String path;
}
