package com.yanzi.study.lession16.jpa;


import com.yanzi.study.lession16.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface UserJPA extends
        JpaRepository<UserEntity,Long>,//SpringDataJPA提供的简单数据操作接口
        Serializable {//序列化接口
    //查询大于20岁的用户
    @Query(value = "select * from t_user where t_age < ?",nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    //根据用户名、密码删除一条数据
    @Transactional
    @Modifying
    @Query(value = "delete from t_user where t_name = ? and t_pwd = ?",nativeQuery = true)
    public void deleteQuery(String name, String pwd);
}
