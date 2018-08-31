package com.yanzi.study.lession14.jpa;

import com.yanzi.study.lession14.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
*QueryDslPredicateExecutor:是SpringDataJPA提供的querydsl查询接口
*@author yanzi
*@Date 14:43 2018/8/31
**/
public interface GoodJPA extends JpaRepository<GoodEntity,Long>,QuerydslPredicateExecutor<GoodEntity> {
}
