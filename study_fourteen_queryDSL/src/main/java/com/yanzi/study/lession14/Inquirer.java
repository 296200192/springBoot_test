package com.yanzi.study.lession14;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.Iterator;
import java.util.List;

/**
*查询条件结果简单封装
*@author yanzi
*@Date 15:54 2018/8/31
**/
public class Inquirer {

    //查询条件集合
    private List<BooleanExpression> expressions;

    public Inquirer(){
        this.expressions = Lists.newArrayList();
    }

    /**
     * 添加查询条件到Query内的查询集合内
     * @param expression
     * @return
     */
    public Inquirer putExpression(BooleanExpression expression){
        //添加到条件集合
        expressions.add(expression);
        return this;
    }

    /**
     * 构建出查询findAll函数使用的Predicate接口查询对象
     * 调用buidleQuery()可直接作为findAll参数查询条件使用
     * @return
     */
    public Predicate buidleQuery(){
        //第一个查询条件对象
        BooleanExpression be = null;
        //遍历所以查询条件，以第一个开始and
        for (int i = 0; i< expressions.size();i++){
            if(i == 0)
                be = expressions.get(i);
            else
                be = be.and(expressions.get(i));
        }
        return be;
    }

    /**
     * 将Iterable集合转换成ArrayList集合
     * @param iterable 源集合
     * @param <T> 类型
     * @return
     */
    public <T> List<T> iteratorToList(Iterable<T> iterable){
        List<T> returnList = Lists.newArrayList();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()){
            returnList.add(iterator.next());
        }
        return returnList;
    }
}
