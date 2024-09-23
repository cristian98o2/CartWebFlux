package co.com.pragma.adapter.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "adapter.elastic.cache")
public class ElasticCacheProperties {
    private String url = "redis-10495.c239.us-east-1-2.ec2.redns.redis-cloud.com";
    private String port = "10495";
    private final String user = "default";
    private final String password = "cristian";
}
