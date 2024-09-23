package co.com.pragma.adapter.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
@EnableRedisRepositories
public class ElasticCacheConfig {

    public static final String CART_CACHE = "cart";

    @Bean
    public RedisCacheManager cacheManager(LettuceConnectionFactory connectionFactory) {
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60));

        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory))
                .cacheDefaults(defaultCacheConfig)
                //.withInitialCacheConfigurations(cacheConfigurations)
                .build();
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(ElasticCacheProperties elasticCacheProperties) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(elasticCacheProperties.getUrl(), Integer.parseInt(elasticCacheProperties.getPort()));
        config.setUsername(elasticCacheProperties.getUser());
        config.setPassword(elasticCacheProperties.getPassword());
        return new LettuceConnectionFactory(config);
    }

    @Bean
    public ReactiveRedisTemplate<String, Object> reactiveRedisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisSerializationContext<String, Object> serializationContext = RedisSerializationContext
                .<String, Object>newSerializationContext(new StringRedisSerializer())
                .value(new GenericJackson2JsonRedisSerializer())
                .build();

        return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
    }

}
