package com.example.datasource.redis;

import org.apache.logging.log4j.LogManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@CacheConfig(cacheNames = "CityService")
public class CityService {


    @Cacheable(key = "#id" ,condition="#id lt 6")//放入缓存
    public CityInfo getCity(int id, String city) {
        System.out.println("不走缓存");
        return new CityInfo(id, city);
}

    @CachePut(key = "#id")//刷新缓存
    public CityInfo addCity(int id, String city) {
        return new CityInfo(id, city);
    }
    @CacheEvict(allEntries=true)
    public void delete(Integer id) {
        System.out.println("delete user by id: " + id);
    }

}