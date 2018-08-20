package com.yanzi.study.chapter6.jpa;

import com.yanzi.study.chapter6.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
*@author yanzi
*@Date 14:24 2018/8/20
**/
public interface UserJPA extends
        JpaRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable{
}
