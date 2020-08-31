package com.ds.spring.boot.utils.redis.service.impl;

import cn.hutool.json.JSONUtil;
import com.ds.spring.boot.utils.redis.service.RedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Author ds
 * @Date 2020/6/4 17:31
 * @Version 1.0
 * @Description
 * @// TODO: 2020/6/4  布隆过滤器
 */
@Service
public class RedisServiceImpl implements RedisService {

   // @Resource
   // private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private HttpServletRequest request;

    @Override
    public boolean getToken(String token) {
        Object SessionToken = request.getSession().getAttribute("token");
        if(false == token.equals(SessionToken)){
            return false;
        }
        return stringRedisTemplate.hasKey(token);
    }

    @Override
    public void put(String key, Object value) {
        String objJson = JSONUtil.toJsonStr(value);
        stringRedisTemplate.opsForValue().set(key,objJson);
    }

    @Override
    public void put(String key, Object value, long seconds) {
        String objJson = JSONUtil.toJsonStr(value);
        stringRedisTemplate.opsForValue().set(key, objJson, seconds, TimeUnit.SECONDS);
    }

    @Override
    public String get(String key) {
        Object json = stringRedisTemplate.opsForValue().get(key);
        if(json != null){
            return String.valueOf(json);
        }
        return null;
    }

    @Override
    public String get(Integer key) {
        return get(String.valueOf(key));
    }

    @Override
    public String get(Long key) {
        return get(String.valueOf(key));
    }
}
