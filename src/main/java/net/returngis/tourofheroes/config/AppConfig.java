package net.returngis.tourofheroes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
class AppConfig {

  @Bean
  public LettuceConnectionFactory redisConnectionFactory() {

    // Get redis configuration from environment variables
    String redisHost = System.getenv("REDIS_HOSTNAME");
    Integer redisPort = Integer.parseInt(System.getenv("REDIS_PORT"));
    String redisPassword = System.getenv("REDIS_PASSWORD");

    // RedisStandalone configuration with credentials
    LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(
        new RedisStandaloneConfiguration(redisHost, redisPort));
    connectionFactory.setPassword(redisPassword);
    return connectionFactory;
  }
}