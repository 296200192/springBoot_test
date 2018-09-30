package com.yanzi.study.lession18.service;

import com.yanzi.study.lession18.entity.Authority;
import com.yanzi.study.lession18.entity.User;
import com.yanzi.study.lession18.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
*HengYuUserDetailsService类中做了从数据库读取用户的操作，
 * 如果没有查询到用户直接抛出异常提示，
 * 如果查询到并且设置对应的角色后返回SpringSecurity内置的User对象实例。
*@author yanzi
*@Date 11:43 2018/9/19
**/
@Component("userDetailsService")
public class HengYuUserDetailsService implements UserDetailsService {
    @Autowired
    private UserJPA userJPA;


    @Override
    public UserDetails loadUserByUsername(final String s){
        String lowercaseLogin = s.toLowerCase();
        User userFromDatabase = userJPA.findByUsernameCaseInsensitive(lowercaseLogin);

        if(userFromDatabase == null){
            throw new UsernameNotFoundException("User"+lowercaseLogin+" was not found in the database");
        }
        //获取用户的所以权限并且SpringSecurity需要的集合
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority:userFromDatabase.getAuthorities()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        //返回一个SpringSecurity需要的用户对象
        return new org.springframework.security.core.userdetails.User(
                userFromDatabase.getUsername(),
                userFromDatabase.getPassword(),
                grantedAuthorities);
    }
}
