package com.yanzi.study.chapter17;


import com.yanzi.study.chapter17.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
*
*@author yanzi
*@Date 16:28 2018/9/18
**/
public interface UserJPA extends JpaRepository<UserEntity,Long>
{
    //使用SpringDataJPA方法定义查询
    public UserEntity findByUsername(String username);
}
