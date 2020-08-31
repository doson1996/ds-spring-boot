package com.ds.spring.boot.utils.redis.service;

/**
 * @Author ds
 * @Date 2020/6/4 17:30
 * @Version 1.0
 * @Description
 */
public interface RedisService {

    boolean getToken(String token);

    void put(String key,Object value);

    void put(String key,Object value,long seconds);

    String get(String key);

    String get(Integer key);

    String get(Long key);
}
