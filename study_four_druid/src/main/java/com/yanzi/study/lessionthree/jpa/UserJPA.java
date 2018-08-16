package com.yanzi.study.lessionthree.jpa;

import com.yanzi.study.lessionthree.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<UserEntity,Long>,//SpringDataJPA提供的简单数据操作接口
        JpaSpecificationExecutor<UserEntity>,//SpringDataJPA提供的复杂查询接口
        Serializable {//序列化接口
}
