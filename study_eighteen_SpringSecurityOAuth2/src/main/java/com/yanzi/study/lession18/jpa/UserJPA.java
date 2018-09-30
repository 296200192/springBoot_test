package com.yanzi.study.lession18.jpa;

import com.yanzi.study.lession18.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJPA extends JpaRepository<User,String> {

    /**
     * HQL语法来构建的语句
     * @param username
     * @return
     */
    @Query("SELECT u from User u where lower(u.username) = lower(:username)")
    User findByUsernameCaseInsensitive(@Param("username") String username);


}
