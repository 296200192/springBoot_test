package com.yanzi.study.lession16.service;

import com.yanzi.study.lession16.entity.UserEntity;
import com.yanzi.study.lession16.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*service内添加redis缓存支持
*@author yanzi
*@Date 11:03 2018/9/17
 *@CacheConfig：该注解是用来开启声明的类参与缓存,如果方法内的@Cacheable注解没有添加key值，那么会自动使用cahceNames配置参数并且追加方法名。
 * @Cacheable：配置方法的缓存参数，可自定义缓存的key以及value。
**/
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserJPA userJPA;

    @Cacheable
    public List<UserEntity> list(){
        return userJPA.findAll();
    }


}
