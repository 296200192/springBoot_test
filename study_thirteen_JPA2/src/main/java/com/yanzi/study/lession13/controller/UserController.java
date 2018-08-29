package com.yanzi.study.lession13.controller;

import com.yanzi.study.lession13.entity.UserEntity;
import com.yanzi.study.lession13.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
*spring boot 整合druid
*@author yanzi
*@Date 14:10 2018/8/16
**/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 查询用户列表方法
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    /**
     * 添加用户、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){
        return userJPA.save(entity);
    }

    /**
     * 单条删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }

    /**
     * 根据条件查询
     * @return
     */
    @RequestMapping(value = "/age")
    public List<UserEntity> age(){
        return userJPA.nativeQuery(24);
    }

    /**
     * 条件删除
     * @return
     */
    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere(){
        userJPA.deleteQuery("admin","123456");
        return "自定义sql删除数据成功";
    }

    /**
     * 分页查询测试
     * @param page 传入页面，从1开始
     * @return
     */
    @RequestMapping(value = "/cutPage")
    public List<UserEntity> cutPage(int page){
        UserEntity user = new UserEntity();
        user.setSize(2);
        user.setSord("desc");
        user.setPage(page);

        //获取排序对象
        Sort.Direction sort_dieection = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord())? Sort.Direction.ASC:Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_dieection,user.getSidx());
        //创建分页对象
        PageRequest pageable = PageRequest.of(user.getPage()-1,user.getSize(),sort);
        //执行分页查询
        return userJPA.findAll(pageable).getContent();
    }
}
