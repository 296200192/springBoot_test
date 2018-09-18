package com.yanzi.study.chapter17.service;


import com.yanzi.study.chapter17.UserJPA;
import com.yanzi.study.chapter17.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
*UserEntity实现了UserDetails接口，
 * UserDetails是SpringSecurity验证框架内部提供的用户验证接口
 * （我们下面需要用到UserEntity来完成自定义用户认证功能），
 * 我们需要实现getAuthorities方法内容，将我们定义的角色列表添加到授权的列表内
*@author yanzi
*@Date 16:28 2018/9/18
**/
public class UserService implements UserDetailsService
{
    @Autowired
    UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userJPA.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("未查询到用户："+username+"信息！");
        }
        return user;
    }
}
