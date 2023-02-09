package com.frankzhou.lottery.config;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description RedisTemplate配置  单机/集群 自定义序列化规则
 * @date 2023-02-02
 */
@Configuration
@EnableCaching
public class RedisConfig extends JCacheConfigurerSupport {

    @Resource
    private RedisProperties redisProperties;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database:0}")
    private Integer database;

    /**
     * Jedis连接工厂 集群/单机
     *
     * @author this.FrankZhou
     * @return JedisConnectionFactory Jedis连接工厂对象
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        // Redis集群
        if (Objects.nonNull(redisProperties.getCluster()) &&
                CollectionUtil.isNotEmpty(redisProperties.getCluster().getNodes())) {
            RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(redisProperties.getCluster().getNodes());
            clusterConfig.setPassword(RedisPassword.of(password));
            return new JedisConnectionFactory(clusterConfig);
        }

        // 单机版Redis
        RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration();
        standaloneConfig.setHostName(host);
        standaloneConfig.setPort(port);
        standaloneConfig.setPassword(RedisPassword.of(password));
        standaloneConfig.setDatabase(database);
        return new JedisConnectionFactory(standaloneConfig);
    }

    /**
     * 设置redisTemplate的序列化与反序列化类型
     *
     * @author this.FrankZhou
     * @params jedisConnectionFactory Jedis连接池
     * @return RedisTemplate 操作redis的对象
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        // 设置连接池
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        // 自动序列化
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);

        return redisTemplate;
    }

    @Bean
    public ValueOperations<String,Object> valueOperations(RedisTemplate<String,Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    public HashOperations<String,String,Object> hashOperations(RedisTemplate<String,Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ListOperations<String,Object> listOperations(RedisTemplate<String,Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String,Object> setOperations(RedisTemplate<String,Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String,Object> zSetOperations(RedisTemplate<String,Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
