package com.yanzi.study.lession8.jpa;

import com.yanzi.study.lession8.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
*日志jpa接口
*@author yanzi
*@Date 9:52 2018/8/23
**/
public interface LoggerJPA extends JpaRepository<LoggerEntity,Long> {
}
