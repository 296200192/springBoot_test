package com.yanzi.study.lession14.controller;

import com.google.common.collect.Lists;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.yanzi.study.lession14.Inquirer;
import com.yanzi.study.lession14.entity.GoodEntity;
import com.yanzi.study.lession14.entity.QGoodEntity;
import com.yanzi.study.lession14.jpa.GoodJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

/**
*@author yanzi
*@Date 14:29 2018/8/31
**/
@RestController
public class QueryController {
    @Autowired
    private GoodJPA goodJPA;

    //注入EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/query")
    public List<GoodEntity> list(){
        //querydsl查询实体
        QGoodEntity goodEntity = QGoodEntity.goodEntity;
        //构建JPA查询对象
        JPAQuery<GoodEntity> jpaQuery = new JPAQuery<>(entityManager);
        //返回查询接口
        return jpaQuery
                //查询字段
                .select(goodEntity)
                //查询表
                .from(goodEntity)
                //查询条件
                .where(goodEntity.type.id.eq(Long.valueOf("1")))
                //返回结果
                .fetch();
    }

    /**
     * spring data jpa 整合querydsl完成查询
     * @return
     */
    @RequestMapping(value = "/join")
    public List<GoodEntity> join(){
        //querydsl查询实体
        QGoodEntity goodEntity = QGoodEntity.goodEntity;

        //查询条件
        BooleanExpression expression = goodEntity.type.id.eq(Long.valueOf("1"));
        //自定义查询对象
        Inquirer inquirer = new Inquirer();
        //添加查询条件
        inquirer.putExpression(goodEntity.type.id.eq(Long.valueOf("1")));
        //返回查询结果
        return inquirer.iteratorToList(goodJPA.findAll(inquirer.buidleQuery()));
    }
}
