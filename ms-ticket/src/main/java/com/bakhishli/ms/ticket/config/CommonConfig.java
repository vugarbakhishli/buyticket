package com.bakhishli.ms.ticket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.bakhishli")
@EnableElasticsearchRepositories(basePackages = "com.bakhishli.ms.ticket.repository.elasticsearch")
public class CommonConfig {
}
